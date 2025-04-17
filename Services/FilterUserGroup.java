package Services;

import java.util.ArrayList;

import BTO.ProjectListing;
import BTO.Applicant;
import Enums.RoomType;

public class FilterUserGroup implements IFilterViewProject{
	private Applicant applicant = null; 
	
	public void setApplicant(Applicant a) { applicant = a; }
	
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects) {
		if (applicant == null) {
			System.out.println("Error: Applicant not entered yet!");
			return projects;
		}
		
		ArrayList<ProjectListing> filtered = new ArrayList<>();
		
		FilterFlatType filterFlat = new FilterFlatType();
		if (applicant.getMaritalStatus().equals("SINGLE") && applicant.getAge() >= 35) {
			System.out.println("FILTERING SINGLE");
			filterFlat.setFlatType(RoomType.TWOROOM); // only gets two room
		}
		else if (applicant.getMaritalStatus().equals("MARRIED") && applicant.getAge() >= 21) {
			System.out.println("FILTERING MARRIED");
			filterFlat.setFlatType(null); // no limit
		}
		else {
			System.out.println("Error: Cannot apply for any!");
			return filtered; // Should technically show nothing?
		}
		filtered = filterFlat.filter(projects);
		
		return filtered;
	}
}
