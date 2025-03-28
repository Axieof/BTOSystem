package BTOSystem;

public class User {

    // Variables
    public String name;
    private String nric;
    public int age;
    public String maritalStatus;
    private String password;

    // Constructor for User
    // (Default password to "password")
    public User(String name, String nric, int age, String maritalStatus) {
        this.name = name;
        this.nric = nric;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.password = "password";
    }

    public User() {

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