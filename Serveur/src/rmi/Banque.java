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
public class Banque  extends UnicastRemoteObject implements CompteInterface {

    private double solde ;
    Banque(double s) throws RemoteException {
        super();
        solde = s;
    }
    @Override
    public boolean debiter(String numOrigine, double montant) throws RemoteException {
        return true;
    }

    @Override
    public boolean crediter(String numOrigine, double montant) throws RemoteException {
        return true;
    }

    @Override
    public boolean transferer(String numOrigine, String numDestination, double montant) throws RemoteException {
        return true;
    }

    @Override
    public String detailsCompte(String numRef) throws RemoteException {
        return "compte.tostring()";
    }
    
}
