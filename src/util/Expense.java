
package util;

import java.time.LocalDate;

/**
 *
 * The Expense class represents an expense made by a user.
 *
 * It contains information such as the ID of the expense, the user who made the
 * expense,
 *
 * the amount spent, the description of the expense, and the date it was made.
 */
public class Expense {
    private int id;
    private int user_id;
    private double amount;
    private String description;
    private LocalDate date;

    // Constructors
/**

Creates an empty Expense object.
*/
    public Expense(){
        
    }

/**

Creates an Expense object with all its attributes.
@param id the ID of the expense
@param user_id the ID of the user who made the expense
@param amount the amount spent in the expense
@param description the description of the expense
@param date the date the expense was made
*/
    public Expense(int id, int user_id, double amount, String description, LocalDate date) {
        this.id = id;
        this.user_id = user_id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

/**

Creates an Expense object without the ID.
The ID is set to 0 by default and should be assigned by a database manager.
@param user_id the ID of the user who made the expense
@param amount the amount spent in the expense
@param description the description of the expense
@param date the date the expense was made
*/
    public Expense(int user_id, double amount, String description, LocalDate date) {
        this.user_id = user_id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
