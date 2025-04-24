package BTO.Controller;

import java.util.HashMap;
import java.util.Scanner;

import BTO.Model.User;
import BTO.Service.MenuInputService;
import BTO.View.UserView;

public class UserSettingsController {

    public static void run(User user, Scanner scanner) {
        boolean running = true;

        while (running) {
            UserView.displayPersonalOptions();
            int choice = MenuInputService.getMenuInput(scanner); // Get user input

            switch (choice) {
                case 0:
                    running = false;
                    UserView.displayExitMessage();
                    break;
                case 1:
                    UserView.displayUser(user); // Display user details
                    break;
                case 2:
                    changePassword(user, scanner); // Change password
                    break;
                case 3:
                    editFilter(user, scanner); // Edit filters
                    break;
                default:
                    UserView.displayInvalidOption();
            }
        }
    }

    private static void changePassword(User user, Scanner scanner) {
        UserView.displayChangePasswordPrompt();

        String currentPassword = scanner.nextLine();
        if (user.checkPassword(currentPassword)) {
            UserView.displayNewPasswordPrompt();
            String newPassword = scanner.nextLine();
            user.changePassword(newPassword);
            UserView.displayPasswordChanged();
        } else {
            UserView.displayIncorrectPassword();
        }
    }

    private static void editFilter(User user, Scanner scanner) {
        HashMap<String, String> filters = user.getFilters();
        String[] allFilters = User.getAllFilterTypes();

        UserView.displayFilters(allFilters);

        int filterIndex = MenuInputService.getMenuInput(scanner);
        if (filterIndex < 0 || filterIndex >= allFilters.length) {
            UserView.displayInvalidFilterSelection();
            return;
        }

        String selectedFilter = allFilters[filterIndex];
        UserView.displayCurrentFilter(selectedFilter, filters.get(selectedFilter));

        UserView.displayFilterChangePrompt();
        String newKey = scanner.nextLine();

        user.setFilter(selectedFilter, newKey.toUpperCase());
        UserView.displayFilterUpdated();
    }
}