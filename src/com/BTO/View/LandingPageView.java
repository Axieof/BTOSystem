package src.com.BTO.View;

public class LandingPageView {
    
    public void showWelcomeMessage() {
        System.out.println("=================================================");
        System.out.println("===== Welcome to the BTO Management System! =====");
        System.out.println("=================================================");
    }

    public void showMainMenu() {
        System.out.println("\n----- Main Menu -----");
        System.out.println("0) Exit");
        System.out.println("1) Login");
        System.out.print("Enter your choice: ");
    }

    public void showInvalidOption() {
        System.out.println("\nInvalid option. Please choose from the menu.");
    }

    public void showExitMessage() {
        System.out.println("\nThank you for using the BTO Management System. Goodbye!");
    }
}
