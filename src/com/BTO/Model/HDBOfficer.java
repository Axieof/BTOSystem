package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;
import java.util.List;

public class HDBOfficer extends Applicant {

    public HDBOfficer(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }
}
