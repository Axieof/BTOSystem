package BTO.Model;

import BTO.Enum.MaritalStatus;
import BTO.Enum.UserType;

public class User {
    
    // Attributes
    private String name;
    private String nric;
    private int age;
    private MaritalStatus maritalStatus;
    private String password;
    private UserType userType;

    // Constructor
    public User(String name, String nric, int age, MaritalStatus maritalStatus, String password, UserType userType) {
        this.name = name;
        this.nric = nric;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.password = password;
        this.userType = userType;
        
    }

    // === Getters ===
    public String getName() { return name; }
    public int getAge() { return age; }
    public MaritalStatus getMaritalStatus() {  return maritalStatus; }
    protected String getNric() { return nric; }
    protected String getPassword() { return password; }
    public UserType getUserType() { return userType; }

    public String getMaskedNric() {
        
        char prefix = nric.charAt(0);
        String visible = nric.substring(5, 8);
        char suffix = nric.charAt(8);

        return prefix + "****" + visible + suffix;
    }

    // === Setters ===
    public void setName(String name) { this.name = name; }

    public void setAge(int age) {  this.age = age; }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // === Methods ===
    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public boolean checkNric(String input) {
        return nric.equals(input);
    }

}
