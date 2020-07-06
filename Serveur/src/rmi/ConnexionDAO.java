/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class ConnexionDAO {

    static  Connection cn = null;

    public static Connection getConnexion(String url, String passwd, String login) {

        if(cn == null)
        {
              try {
                    cn = DriverManager.getConnection(url, login, passwd);
                } catch (SQLException e) {
                    System.err.println(e.toString());
                }
        }
        return cn;
    }
    
    public static boolean close() {
        try {
             ConnexionDAO.cn.close();
          } catch (SQLException e) {
              System.err.println(e.toString());
          }
        return true;
    }
}
