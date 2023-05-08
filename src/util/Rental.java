package util;
import java.time.LocalDateTime;

public class Rental {
    

    // rental_id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    // tenant_id int(11) NOT NULL,
    // room_id int(11) NOT NULL,
    // check_in_date datetime NOT NULL,
    // check_out_date datetime NOT NULL,
    // total_amount decimal(10,2) NOT NULL
    
    //Attributes
    private int rental_id;
    private int tenant_id;
    private int room_id;
    private LocalDateTime check_in_date;
    private LocalDateTime check_out_date;
    private double total_amount;

    //Constructor
    public Rental() {
    }

    public Rental(int rental_id, int tenant_id, int room_id, LocalDateTime check_in_date, LocalDateTime check_out_date, double total_amount) {
        this.rental_id = rental_id;
        this.tenant_id = tenant_id;
        this.room_id = room_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_amount = total_amount;
    }

    //Getters and Setters
    public int getRental_id() {
        return this.rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getTenant_id() {
        return this.tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public int getRoom_id() {
        return this.room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public LocalDateTime getCheck_in_date() {
        return this.check_in_date;
    }

    public void setCheck_in_date(LocalDateTime check_in_date) {
        this.check_in_date = check_in_date;
    }

    public LocalDateTime getCheck_out_date() {
        return this.check_out_date;
    }

    public void setCheck_out_date(LocalDateTime check_out_date) {
        this.check_out_date = check_out_date;
    }

    public double getTotal_amount() {
        return this.total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

}
