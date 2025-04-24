package BTO.Service;

import java.util.List;
import java.util.Scanner;

import BTO.Model.User;

public class AuthService {
    public static User authenticate(List<User> data, Scanner scanner) {

        System.out.print("Enter NRIC: ");
        String nricInput = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String passwordInput = scanner.nextLine().trim();

        return data.stream()
            .filter(u -> u.checkNric(nricInput))
            .filter(u -> u.checkPassword(passwordInput))
            .findFirst()
            .orElse(null);
    }
}
