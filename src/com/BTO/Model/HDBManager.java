package src.com.BTO.Model;

public class HDBManager extends User {
    // Constructor for Applicant
    public HDBManager (String name, String nric, int age, String maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password, "HDBMANAGER");
    }

    @Override
    public String toString() {
        return "HDBManager [name=" + getName() + ", age=" + getAge() + ", maritalStatus=" + getMaritalStatus() + "]";
    }
}
