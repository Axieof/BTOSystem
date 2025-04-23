package src.com.BTO.Model;

// Imports
import src.com.BTO.Model.Enums.MaritalStatus;
import java.util.HashMap;

public class User {

    // Attributes
    private String name;
    private String nric;
    private int age;
    private MaritalStatus maritalStatus;
    private String password;
    
    private static final String[] FILTERTYPES = {"FilterProjectFlatType", "FilterProjectLocation"};
    private HashMap<String, String> filters = new HashMap<>(); 

    // Constructor
    public User(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        this.name = name;
        this.nric = nric;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.password = password;
        
        // default filter null
        for (String filt : FILTERTYPES) { 
        	filters.put(filt, "NULL");
        }
    }

    // === Getters ===
    public String getName() { return name; }

    public int getAge() { return age; }

    public MaritalStatus getMaritalStatus() {  return maritalStatus; }

    public String getMaskedNric() {
        return "****" + nric.substring(nric.length() - 4);
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }

    public static String[] getAllFilterTypes() { return FILTERTYPES; }
    public void setFilter(String filterType, String key) {
    	filters.put(filterType, key);
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
    
    public HashMap<String, String> getFilters() { return filters; }

}
