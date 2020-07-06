/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Client implements Serializable{
    private String code ;
    private String nom;
    private String postnom;
    private String prenom;
    private Date datenaisance;

    public Client() {
    }

    public Client(String code, String nom, String postnom, String prenom, Date datenaisance) {
        this.code = code;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.datenaisance = datenaisance;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the postnom
     */
    public String getPostnom() {
        return postnom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the datenaisance
     */
    public Date getDatenaisance() {
        return datenaisance;
    }


}
