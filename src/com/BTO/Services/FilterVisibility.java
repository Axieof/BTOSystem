package src.com.BTO.Services;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import src.com.BTO.ProjectListing;
import src.com.BTO.Unit;

public class FilterVisibility implements IFilterViewProject{
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects) {
		
		// Filter visibility off
		List<ProjectListing> filteredList = projects.stream()
				.filter(o -> o.getVisibility()).collect(Collectors.toList());
		ArrayList<ProjectListing> filteredArrList = new ArrayList<>(filteredList);
		
		ArrayList<Unit> toDelete; 
		
		// Remove units with 0 vacancy (should not be visible)
		for (ProjectListing proj : filteredArrList) {
			toDelete = new ArrayList<>();

			for (Unit unit : proj.getUnitTypes()) {
				if (unit.getUnitCount() <= 0) toDelete.add(unit);
			}
			
			for (int i=0; i<toDelete.size(); i++) {
				proj.removeUnitType(toDelete.get(i)); 
			}
		}
		
		return filteredArrList;
	}
}
