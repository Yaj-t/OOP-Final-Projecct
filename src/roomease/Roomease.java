/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roomease;

import database.Connect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Predator
 */
public class Roomease {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Connect.connectToDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Roomease.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login login = new Login();
        login.setVisible(true);
//        new Home().setVisible(true);
        
    }
    
}
