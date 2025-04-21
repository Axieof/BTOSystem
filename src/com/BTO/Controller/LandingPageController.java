package src.com.BTO.Controller;

import java.util.List;
import java.util.Scanner;

import src.com.BTO.Model.*;
import src.com.BTO.Controller.*;
import src.com.BTO.View.*;
import src.com.BTO.Service.*;

public class LandingPageController {
    
    private final AuthService authService;
    private final LandingPageView landingView;
    private final MenuInputService menuInputService;

    public LandingPageController(List<User> users) {
        this.authService = new AuthService(users);
        this.landingView = new LandingPageView();
        this.menuInputService = new MenuInputService();
    }

    public User run(Scanner scanner) {
        boolean running = true;

        // Step [1] - Show Welcome Message
        landingView.showWelcomeMessage();

        while (running) {

            // Step [2] Show Main Menu
            landingView.showMainMenu();

            // Step [3] Get User Input
            int choice = menuInputService.getMenuInput(scanner);

            // Step [4] Handle User Choice
            switch(choice) {
                case 0:
                    landingView.showExitMessage();
                    running = false;
                    return null;

                case 1:
                    User user = authService.authenticate(scanner);
                    if (user != null) {
                        running = false;
                        return user;
                    }
                    break;

                default:
                    landingView.showInvalidOption();
                    return null;
            }
        }

        return null;
    }

}
