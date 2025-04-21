package src.com.BTO.Service;

import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.*;
import src.com.BTO.View.*;

public class AuthService {
    
    private final List<User> users;
    private final AuthView authView;
    
    public AuthService(List<User> users) {
        this.users = users;
        this.authView = new AuthView();
    }

    public User authenticate(Scanner scanner) {
        boolean retry = true;

        while (retry) {
            authView.showLoginPrompt();

            authView.showUsernamePrompt();
            String username = scanner.nextLine();

            authView.showPasswordPrompt();
            String password = scanner.nextLine();

            // Attempt to find user
            User matchedUser = users.stream()
                .filter(u -> u.getName().equals(username) && u.checkPassword(password))
                .findFirst()
                .orElse(null);

            if (matchedUser != null) {
                authView.showSuccess(username);
                return matchedUser;
            } else {
                authView.showError("Invalid username or password.");
                authView.showRetryOption();
                String retryChoice = scanner.nextLine().trim().toLowerCase();
                if (!retryChoice.equals("y")) {
                    retry = false;
                }
            }
        }

        return null; // user gave up or failed
    }
}
