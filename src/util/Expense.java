package util;


import java.time.LocalDate;

public class Expense {
    private int id;
    private double amount;
    private String description;
    private LocalDate date;

    // Constructors
    
    public Expense(){
        
    }

    public Expense(double amount, LocalDate date, String description) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }
    
    
    public Expense(int id, double amount, String description, LocalDate date) {
        this.id = id;
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
