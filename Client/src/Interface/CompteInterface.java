/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Dell
 */
public interface CompteInterface extends java.rmi.Remote {

    boolean debiter(String numOrigine, double montant)
            throws java.rmi.RemoteException;

    boolean crediter(String numOrigine, double montant)
            throws java.rmi.RemoteException;
    
    boolean transferer(String numOrigine , String numDestination, double montant)
            throws java.rmi.RemoteException;
    
    String  detailsCompte(String numRef)
            throws java.rmi.RemoteException;
};