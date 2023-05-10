/**
 *
 * The Payment class represents a payment made for a rental by a tenant to an employee..
 * It includes information such as payment ID, rental ID, employee ID, payment amount, payment date, and payment description.
 */
package util;

import java.time.LocalDate;

public class Payment {
    
  // Attributes
    private int payment_id;
    private int rental_id;
    private int employee_id;
    private double amount;
    private LocalDate payment_date;
    private String description;

    // Constructors
    public Payment() {
    }

    /**
     * Constructs a Payment object with the given parameters.
     *
     * @param payment_id the payment ID
     * @param rental_id the rental ID
     * @param employee_id the employee ID
     * @param amount the payment amount
     * @param payment_date the payment date
     * @param description the payment description
     */
    public Payment(int payment_id, int rental_id, int employee_id, double amount, LocalDate payment_date, String description) {
        this.payment_id = payment_id;
        this.rental_id = rental_id;
        this.employee_id = employee_id;
        this.amount = amount;
        this.payment_date = payment_date;
        this.description = description;
    }

    /**
     * Constructs a Payment object with the given parameters. Sets payment ID to
     * 0 and payment date to the current date.
     *
     * @param rental_id the rental ID
     * @param employee_id the employee ID
     * @param amount the payment amount
     * @param description the payment description
     */

    public Payment(int rental_id, int employee_id, double amount, String description) {
        this.payment_id = 0;
        this.rental_id = rental_id;
        this.employee_id = employee_id;
        this.amount = amount;
        this.payment_date = LocalDate.now();
        this.description = description;
    }

    // Getters and setters
    public int getPayment_id() {
        return this.payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getRental_id() {
        return this.rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPayment_date() {
        return this.payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
