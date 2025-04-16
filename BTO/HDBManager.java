package BTO;

public class HDBManager extends User {
    // Constructor for Applicant
    public HDBManager (String name, String nric, int age, String maritalStatus, String password, String role) {
        super(name, nric, age, maritalStatus, password, role);
    }

    @Override
    public String toString() {
        return "HDBManager [name=" + getName() + ", age=" + getAge() + ", maritalStatus=" + getMaritalStatus() + "]";
    }
}
