/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class RMIOperations extends UnicastRemoteObject implements CompteInterface{  
    private  OperationCompteDAO compteDAO = null;
    private final  Transaction transaction = new Transaction();


    RMIOperations(String pwd , String login, int port) throws java.rmi.RemoteException 
    {
        super();
        compteDAO = new OperationCompteDAO(pwd, login, port);
    }
    @Override
    public boolean debiter(String numOrigine, double montant) throws RemoteException {
        transaction.setRefOrigine(numOrigine);
        transaction.setType("Debiter");
        transaction.setMontant(montant);
        return compteDAO.nouvelleTransaction(transaction);
    }

    @Override
    public boolean crediter(String numOrigine, double montant) throws RemoteException {
        transaction.setRefOrigine(numOrigine);
        transaction.setType("Crediter");
        transaction.setMontant(montant);
        return compteDAO.nouvelleTransaction(transaction);
    }
    
    @Override
    public boolean transferer(String numOrigine, String numDestination, double montant) throws RemoteException {
       transaction.setRefOrigine(numOrigine);
       transaction.setRefDestination(numDestination);
        transaction.setType("Transferer");
        transaction.setMontant(montant);
        return compteDAO.nouvelleTransaction(transaction); 
    }

    @Override
    public String detailsCompte(String numRef) throws RemoteException {
        return compteDAO.getCompte(numRef).toString();
    }

    
    
    
}
