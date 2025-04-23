package src.com.BTO.Model;

import java.util.ArrayList;
import java.util.List;

import src.com.BTO.Model.Enums.MaritalStatus;
import src.com.BTO.Service.*;

public class Applicant extends User implements ICSVWritable {

    private Application appliedProject = null; // Project user has applied for
	private Project bookedProject = null;
	private Unit bookedUnit = null;
	
    private List<Enquiry> enquiryList = new ArrayList<>();
    private int projectID = -1;

    public Applicant(String name, String nric, int age, MaritalStatus maritalStatus, String password) {
        super(name, nric, age, maritalStatus, password);
    }
    
    public Application getApplied() { return appliedProject; }
    public void setApplied(Application app) { appliedProject = app; }

    public List<Enquiry> getEnquiryList(){return enquiryList;}
    public void setEnquiryList(List<Enquiry> enquiryList){this.enquiryList = enquiryList;}
    public void addEnquiry(Enquiry enq) { enquiryList.add(enq); }

    public int getProjectID(){return projectID;}
    public void setProjectID(){this.projectID = projectID;}
    
    public Project getBookedProject() { return bookedProject; }
    public Unit getBookedUnit() { return bookedUnit; }
    public void setBookedProject(Project booked, Unit u) { 
    	bookedProject = booked; 
    	bookedUnit = u;
    }

    @Override
    public String toCSV() {
        return String.join(",",
            getName(),
            getNric(),
            String.valueOf(getAge()),
            String.valueOf(getMaritalStatus()),
            getPassword()
        );
    }
}
