/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;
import enums.UserType;
/**
 *
 * @author T-jay
 */
public class User {
//    public static User currentUser;
    private int userID;
    private UserType type;
    private String username;
    private String password;
    private String name;

    public User(UserType type, String username, String password, String name) {
        this.type = type;
        this.username = username;
        this.password = password;
        this.name = name;
    }
    
    public User(int userID, UserType type, String username, String password, String name) {
        this.userID = userID;
        this.type = type;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
