package user;
import enums.UserType;

/**
 * Represents a user of the system.
 */
public class User {
    private int userID;
    private UserType type;
    private String username;
    private String password;
    private String name;

    /**
     * Creates a new User with the specified type, username, password, and name.
     *
     * @param type The type of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param name The name of the user.
     */
    public User(UserType type, String username, String password, String name) {
        this.type = type;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    /**
     * Creates a new User with the specified ID, type, username, password, and name.
     *
     * @param userID The ID of the user.
     * @param type The type of the user.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param name The name of the user.
     */
    public User(int userID, UserType type, String username, String password, String name) {
        this.userID = userID;
        this.type = type;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    /**
     * Returns the ID of the user.
     *
     * @return The ID of the user.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the ID of the user.
     *
     * @param userID The ID of the user.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Returns the type of the user.
     *
     * @return The type of the user.
     */
    public UserType getType() {
        return type;
    }

    /**
     * Sets the type of the user.
     *
     * @param type The type of the user.
     */
    public void setType(UserType type) {
        this.type = type;
    }

    /**
     * Returns the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }
}
