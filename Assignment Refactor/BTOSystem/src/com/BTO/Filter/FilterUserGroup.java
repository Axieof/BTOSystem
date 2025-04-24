package src.com.BTO.Service.Filter;

import java.util.ArrayList;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Enums.*;
import src.com.BTO.Model.Applicant;

public class FilterUserGroup implements IFilterProject{
	private Applicant applicant = null; 
	
	public void setCondition(Applicant a) { applicant = a; }
	
	public ArrayList<Project> filter(ArrayList<Project> projects) {
		if (applicant == null) {
			System.out.println("Error: Applicant not entered yet!");
			return projects;
		}
		
		ArrayList<Project> filtered = new ArrayList<>();
		
		FilterProjectFlatType filterFlat = new FilterProjectFlatType();
		if (applicant.getMaritalStatus() == MaritalStatus.SINGLE && applicant.getAge() >= 35) {
			filterFlat.setRoomType(RoomType.TWOROOM); // only gets two room
		}
		else if (applicant.getMaritalStatus() == MaritalStatus.MARRIED && applicant.getAge() >= 21) {
			filterFlat.setRoomType(null); // no limit
		}
		else {
			System.out.println("Error: Cannot apply for any!");
			return filtered; // Should technically show nothing?
		}
		filtered = filterFlat.filter(projects);
		
		return filtered;
	}
}
