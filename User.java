package BTOSystem;

public class User {

    // Variables
    private String name;
    private String nric;
    private int age;
    private String maritalStatus;
    private String password;

    // Constructor
    // (Default password to "password")
    public User(String name, String nric, int age, String maritalStatus) {
        this.name = name;
        this.nric = nric;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.password = "password";
    }

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