package src.com.BTO.View;

public class AuthView {

    public void showLoginPrompt() {
        System.out.println("\n--- Login ---");
    }

    public void showUsernamePrompt() {
        System.out.print("Enter Name: ");
    }

    public void showPasswordPrompt() {
        System.out.print("Enter Password: ");
    }

    public void showSuccess(String name) {
        System.out.println("\nWelcome, " + name + "!");
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showRetryOption() {
        System.out.println("Would you like to try again? (y/n): ");
    }
}
