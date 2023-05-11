package roomease;

/**
*The Roomease class is the entry point for the application. It contains the main method
*which creates and displays the login page of the application.
*/
public class Roomease {
    
    public static void main(String[] args) {
        LoginPage login;
        login = new LoginPage();
        login.setVisible(true);
    }
}