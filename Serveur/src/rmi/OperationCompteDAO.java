/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class OperationCompteDAO{

    private String url = null;
    private Statement st = null;
    private Connection cn = null;

    public OperationCompteDAO(String pwd, String login, int port) {
        
        //Set of port
        url = "jdbc:postgresql://localhost:"+port+"/banque";
        this.cn = ConnexionDAO.getConnexion(this.url, pwd, login);

        try {
            this.st = cn.createStatement();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public boolean nouvelleTransaction(Transaction transaction) {
        try {
             //Mise a jour du solde
            updateCompte(transaction);
            
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Transaction (refOrigine,refDestination,montant, type) VALUES (?,?,?,?)");
            ps.setString(1, transaction.getRefOrigine());      //refOrigine
            ps.setString(2, transaction.getRefDestination());      //refDestination
            ps.setDouble(3, transaction.getMontant());     //montant
            ps.setString(4, transaction.getType());     //montant
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return true;
    }
    
     private void updateCompte(Transaction transaction) {
        double value = ("Transferer".equals(transaction.getType()) ||  "Crediter".equals(transaction.getType()) ) ?
                    - transaction.getMontant() : transaction.getMontant();
        double solde = 0;
        ResultSet rs;
            
        try {
            //Mise a jour du compte de l'expediteur
            PreparedStatement ps = cn.prepareStatement("UPDATE compte SET solde = solde + (?) where numRef = ?");
            ps.setDouble(1, value);     //montant
            ps.setString(2, transaction.getRefOrigine());      //refOrigine
            ps.executeUpdate();
            
            if(transaction.getType().equals("Transferer"))
            {
                
                //Mise a jour du compte de du destinataire
                ps = cn.prepareStatement("UPDATE compte SET solde = solde + ? where numRef = ?");
                ps.setDouble(1, transaction.getMontant());     //montant
                ps.setString(2, transaction.getRefDestination());      //refOrigine
                ps.executeUpdate();

            }
            ps.close();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

    public Compte getCompte(String numRef ) {
		ResultSet rs;
		Compte compte = null;
		try {
			String sql = "SELECT * FROM  compte where numRef ='" + numRef +"'";
			rs = st.executeQuery(sql);
                        
			while (rs.next()) {
                            //String numRef, String type, Date datecreation, String codeClient, double solde
				 compte = new Compte(rs.getString("numRef"), rs.getString("type"), rs.getDate("dateCreation"), rs.getString("codeClient"), rs.getDouble("solde"));
			}

		} catch (SQLException e) {
                       System.err.println(e.toString());
		} 
		return compte;
	}
}
