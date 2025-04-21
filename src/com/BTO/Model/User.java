package src.com.BTO.Model;

import src.com.BTO.Model.Enums.MaritalStatus;

public class User {
    protected String name;
    private String nric;
    protected int age;
    protected MaritalStatus maritalStatus;
    private String password;

    public User(String nameArg, String nricArg, int ageArg, MaritalStatus maritalStatusArg, String passwordArg) {
        this.name = nameArg;
        this.nric = nricArg;
        this.age = ageArg;
        this.maritalStatus = maritalStatusArg;
        this.password = passwordArg;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatusArg) {
        this.maritalStatus = maritalStatusArg;
    }

}
