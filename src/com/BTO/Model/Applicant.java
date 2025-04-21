package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;
import java.util.ArrayList;
import java.util.List;

public class Applicant extends User {

    public Applicant(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }
    
}
