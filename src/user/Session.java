package user;

public class Session {

    private static User currentUser;

    //Constructor
    public Session() {
    }

    public Session(User currentUser) {
        Session.currentUser = currentUser;
    }

    //Getter and Setter

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Session.currentUser = currentUser;
    }

    public static void logout() {
        currentUser = null;
    }

}
