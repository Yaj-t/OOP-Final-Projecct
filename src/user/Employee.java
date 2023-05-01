/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import enums.UserType;

/**
 *
 * @author Predator
 */
public class Employee extends User{
    
    public Employee( UserType type, String username, String password, String name) {
        super( type, username, password, name);
    }
    
    
}
