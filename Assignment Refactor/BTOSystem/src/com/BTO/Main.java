package BTO;

import BTO.Controller.SystemController;
import BTO.Model.SystemData;
import BTO.View.SystemView;

public class Main {
    public static void main(String[] args) {

        SystemData systemData = SystemController.initializeData();

        // Testing to view all users
        //SystemView.displayAllusers(systemData.getAllUsers());

        SystemController.start(systemData);

    }
}