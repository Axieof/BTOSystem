package BTO;

public class HDBManager extends User {
    // Constructor for Applicant
    public HDBManager (String name, String nric, int age, String maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }

    @Override
    public String toString() {
        return "HDBManager [name=" + name + ", age=" + age + ", maritalStatus=" + maritalStatus + "]";
    }
}
