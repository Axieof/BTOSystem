package BTO;

public class Applicant extends User {

    // Constructor for Applicant
    public Applicant (String name, String nric, int age, String maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }

    @Override
    public String toString() {
        return "Applicant [name=" + name + ", age=" + age + ", maritalStatus=" + maritalStatus + "]";
    }
}
