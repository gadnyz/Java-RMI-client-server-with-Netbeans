/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;
 
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Compte {
  private  String numRef ;
  private String type;
  private Date datecreation;
  private String codeClient;
  private double solde;

    public Compte() {
    }
    
    public Compte(String numRef) {
        this.numRef = numRef;
    }

    public Compte(String numRef, String type, Date datecreation, String codeClient, double solde) {
        this.numRef = numRef;
        this.type = type;
        this.datecreation = datecreation;
        this.codeClient = codeClient;
        this.solde = solde;
    }

    /**
     * @return the numRef
     */
    public String getNumRef() {
        return numRef;
    }

    /**
     * @param numRef the numRef to set
     */
    public void setNumRef(String numRef) {
        this.numRef = numRef;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the datecreation
     */
    public Date getDatecreation() {
        return datecreation;
    }

    /**
     * @param datecreation the datecreation to set
     */
    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    /**
     * @return the codeClient
     */
    public String getCodeClient() {
        return codeClient;
    }

    /**
     * @param codeClient the codeClient to set
     */
    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    /**
     * @return the solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    /**
     * 
     * @param montant
     * @return 
     */
    
    public boolean crediter(double montant)
    {
        if(this.solde >= montant)
        {
            this.solde = this.solde - montant;
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param montant
     * @return 
     */
    public boolean debiter(double montant)
    {
        this.solde = this.solde  + montant;
        return true;
    }
    
  @Override
    public String toString()
    {
        return this.numRef+" "+ this.codeClient +" "+type+" "+this.datecreation+" "+this.solde;
    }

    public double lire_solde() throws RemoteException {
        return this.solde;
    }
    
}
