package BTO.Model;

import BTO.Enum.MaritalStatus;
import BTO.Enum.UserType;

public class HDBManager extends User{
    
    public HDBManager(String name, String nric, int age, MaritalStatus maritalStatus, String password, UserType userType) {
        super(name, nric, age, maritalStatus, password, userType);
    }
}
