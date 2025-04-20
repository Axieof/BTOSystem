package BTO;

public class User {

    // Variables
    private String name;
    private String nric;
    private int age;
    private String maritalStatus;
    private String password;
    private String role;

    // Constructor for User
    // (Default password to "password")
    public User(String name, String nric, int age, String maritalStatus, String password， String role) {
        this.name = name;
        this.nric = nric;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    // getter
    public String getName() {return name;}
    public String getNric() {return nric;}
    public int getAge() {return age;}
    public String getMaritalStatus() {return maritalStatus;}
    public String getPassword() {return password;}
    public String getRole() {return role;}
    
    // setters
    public void setPassword(String newPassword) {this.password = newPassword;}
    public void setRole(String role) {this.role = role;}
    public void setDefaultPassword() {this.password = "password";}


    // Password changing method
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully");
            return true;
        } else {
            System.out.println("Current password is incorrect. Try Again");
            return false;
        }

        // Possible additional functionality - password requirements
    }

}