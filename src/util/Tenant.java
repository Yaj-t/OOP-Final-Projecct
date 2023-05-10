package util;

/**
 * Represents a tenant in the system.
 */
public class Tenant {   
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    /**
     * Constructs a Tenant object with the specified parameters.
     *
     * @param id the ID of the tenant
     * @param firstName the first name of the tenant
     * @param lastName the last name of the tenant
     * @param phoneNumber the phone number of the tenant
     * @param email the email address of the tenant
     */
    public Tenant(int id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Constructs a Tenant object with the specified parameters.
     *
     * @param firstName the first name of the tenant
     * @param lastName the last name of the tenant
     * @param phoneNumber the phone number of the tenant
     * @param email the email address of the tenant
     */
    public Tenant(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    /**
     * Returns the ID of the tenant.
     *
     * @return the ID of the tenant
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the tenant.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the tenant.
     *
     * @return the first name of the tenant
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the tenant.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the tenant.
     *
     * @return the last name of the tenant
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the tenant.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the phone number of the tenant.
     *
     * @return the phone number of the tenant
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the tenant.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the email address of the tenant.
     *
     * @return the email address of the tenant
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the tenant.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
