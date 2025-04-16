package BTO;

public class HDBOfficer extends Applicant {
    
    // Constructor for HDB Officer
    public HDBOfficer(String name, String nric, int age, String maritalStatus, String password, String role) {
        super(name, nric, age, maritalStatus, password, role);
    }

    @Override
    public String toString() {
        return "HDBOfficer [name=" + getName() + ", age=" + getAge() + ", maritalStatus=" + getMaritalStatus() + "]";
    }

}
