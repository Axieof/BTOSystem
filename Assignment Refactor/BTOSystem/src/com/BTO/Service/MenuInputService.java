package BTO.Service;

import java.util.Scanner;

public class MenuInputService {
    
    public static int getMenuInput(Scanner scanner) {
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }
}