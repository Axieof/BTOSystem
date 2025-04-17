package BTO;

public class Applicant extends User {
    private String appliedProjectName;
    private String applicationStatus;
    private int flatType;

    // Constructor for Applicant
    public Applicant (String name, String nric, int age, String maritalStatus, String password, String role) {
        super(name, nric, age, maritalStatus, password, role);
    }

    @Override
    public String toString() {
        return "Applicant [name=" + getName() + ", age=" + getAge() + ", maritalStatus=" + getMaritalStatus() + "]";
    }
}
