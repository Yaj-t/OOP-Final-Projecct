/**

The Session class represents the session of a user who has logged into the system.
It provides methods to set and get the current user, retrieve the ID of the current user,
and log out the current user.
*/
package util;

import database.UserDAO;

public class Session {

    /**
 * The current user who is logged in.
 */
public static User currentUser = null;

/**
 * Constructs a new Session object.
 */
public Session() {
}

/**
 * Constructs a new Session object with the specified currentUser.
 * @param currentUser the current user who is logged in.
 */
public Session(User currentUser) {
    Session.currentUser = currentUser;
}

/**
 * Gets the current user who is logged in.
 * @return the current user who is logged in.
 */
public static User getCurrentUser() {
    return currentUser;
}

/**
 * Sets the current user who is logged in.
 * @param currentUser the current user who is logged in.
 */
public static void setCurrentUser(User currentUser) {
    Session.currentUser = currentUser;
}

/**
 * Gets the ID of the current user who is logged in.
 * @return the ID of the current user who is logged in.
 */
public static int getCurrentUserId() {
    return currentUser.getUserID();
}

/**
 * Logs out the current user by setting currentUser to null.
 */
public static void logout() {
    currentUser = null;
}

}
