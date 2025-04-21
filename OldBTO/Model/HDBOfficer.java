package src.com.BTO.Model;

import src.com.BTO.Model.Applicant;

public class HDBOfficer extends Applicant {
    
    // Constructor for HDB Officer
    public HDBOfficer(String name, String nric, int age, String maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
        this.setRole("HDBOFFICER");
    }

    @Override
    public String toString() {
        return "HDBOfficer [name=" + getName() + ", age=" + getAge() + ", maritalStatus=" + getMaritalStatus() + "]";
    }

}
