/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class RMIServeur {
    
    public static void main(String[] args) throws AlreadyBoundException {
        Scanner enterValue = new Scanner(System.in);
        
        System.out.print("IP : ");
        String ip = enterValue.nextLine();
        
        System.out.print("Login : ");
        String login = enterValue.nextLine();
        
        System.out.print("Password : ");
        String pwd = enterValue.nextLine();
        
        System.out.print("Port (database) : ");
        int port = enterValue.nextInt();
        
        try {
                if(ip.isEmpty())
                {
                    ip =InetAddress.getLocalHost().toString();
                }

                
                RMIOperations rmio = new RMIOperations(pwd, login, port);

                Naming.rebind("rmi://"+ip+":1099/OperationBanque",rmio);
                System.out.println("Serveur ready on ["+ip+"]  ...");

            } catch (RemoteException | MalformedURLException | java.net.UnknownHostException e) {
                System.out.println("ERROR : the server cannot connect to the object OperationBanque");
                System.out.println(e.toString());
            }
    }
    
}





















//                RMIOperations obj = new RMIOperations(); 
//                CompteInterface stub = (CompteInterface) UnicastRemoteObject.exportObject(obj, 0);  
//                // Binding the remote object (stub) in the registry 
//                Registry registry = LocateRegistry.getRegistry(); 
//
//                registry.bind("RMIOperations", stub);  
//                System.out.println("Server ready");












//