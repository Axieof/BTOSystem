package BTO.Model;

import BTO.Enum.MaritalStatus;
import BTO.Enum.UserType;

public class Applicant extends User{
    public Applicant(String name, String nric, int age, MaritalStatus maritalStatus, String password, UserType userType) {
        super(name, nric, age, maritalStatus, password, userType);
    }
}
