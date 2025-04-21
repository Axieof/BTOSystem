package src.com.BTO;

// Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.BTO.Service.CSVLoaderService;
import src.com.BTO.Model.User;
import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.HDBManager;
import src.com.BTO.Model.HDBOfficer;
import src.com.BTO.Controller.LandingPageController;
import src.com.BTO.Model.Enums.MaritalStatus;

public class Main {
    public static void main(String[] args) {

        // Initialize central scanner to pass to core functions
        Scanner mainScanner = new Scanner(System.in);

        // Step [1] - Load all data from csv
        CSVLoaderService csvLoader = new CSVLoaderService();
        List<User> users = new ArrayList<>();

        // Load from csv files into a central list
        users.addAll(csvLoader.loadcsv("Data/ApplicantList.csv", columns -> new Applicant(columns[0], columns[1], Integer.parseInt(columns[2]), MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4])));
        users.addAll(csvLoader.loadcsv("Data/OfficerList.csv", columns -> new HDBOfficer(columns[0], columns[1], Integer.parseInt(columns[2]), MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4])));
        users.addAll(csvLoader.loadcsv("Data/ManagerList.csv", columns -> new HDBManager(columns[0], columns[1], Integer.parseInt(columns[2]), MaritalStatus.valueOf(columns[3].toUpperCase()), columns[4])));

        // Step [2] - Show landing page
        LandingPageController landingController = new LandingPageController(users);
        User loggedInUser = landingController.run(mainScanner);

        // Step [3] - Dispatch accordingly
        //landingController.dispatch(loggedInUser);

        
    }
}
