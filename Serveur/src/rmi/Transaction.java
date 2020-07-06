/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.Date;

/**
 *
 * @author Dell
 */

public class Transaction {
    private  String transactionID ;
    private String refOrigine;
    private String refDestination;
    private double montant;
    private Date dateTransaction;
    private String type;

    public Transaction() {
        generateTransactrionID();
      //  this.dateTransaction = new Date("11-02-2020"); //Normalement doit avoir la date actuelle du systeme
    }

    public Transaction(String transactionID, String refOrigine, String refDestination, double montant, Date dateTransaction, String type) {
        this.transactionID = transactionID;
        this.refOrigine = refOrigine;
        this.refDestination = refDestination;
        this.montant = montant;
        this.dateTransaction = dateTransaction;
        this.type = type;
    }

    /**
     * @return the transactionID
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * @return the refOrigine
     */
    public String getRefOrigine() {
        return refOrigine;
    }

    /**
     * @param refOrigine the refOrigine to set
     */
    public void setRefOrigine(String refOrigine) {
        this.refOrigine = refOrigine;
    }

    /**
     * @return the refDestination
     */
    public String getRefDestination() {
        return refDestination;
    }

    /**
     * @param refDestination the refDestination to set
     */
    public void setRefDestination(String refDestination) {
        this.refDestination = refDestination;
    }

    /**
     * @return the montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * @return the dateTransaction
     */
    public Date getDateTransaction() {
        return dateTransaction;
    }

    /**
     * @param dateTransaction the dateTransaction to set
     */
    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
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
    
    private void generateTransactrionID(){
        this.transactionID ="1452XS41D4FID";
    }
    
}
