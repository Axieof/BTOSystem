package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;
import java.util.ArrayList;
import java.util.List;

public class HDBManager extends User {

    public HDBmanager(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }
    
}