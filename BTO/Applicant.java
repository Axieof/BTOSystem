package BTO;

public class Applicant extends User {

    // Constructor for Applicant
    public Applicant (String name, String nric, int age, String maritalStatus, String password) { 
        super(name, nric, age, maritalStatus, password, "APPLICANT");
    }

    @Override
    public String toString() {
        return "Applicant [name=" + getName() + ", age=" + getAge() + ", maritalStatus=" + getMaritalStatus() + "]";
    }
}
