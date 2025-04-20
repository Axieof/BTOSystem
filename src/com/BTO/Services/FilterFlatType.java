package src.com.BTO.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Enums.RoomType;
import src.com.BTO.Model.ProjectListing;
import src.com.BTO.Model.Unit;

public class FilterFlatType implements IFilterViewProject{
	private RoomType flatType = null;
	
	// set flat type to null if want no effect
	public void setFlatType(RoomType roomtype) { flatType = roomtype; }
	
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects) {
		ArrayList<Unit> toDelete;
		
		// remove irrelevant flat types
		if(flatType != null) {
			for (ProjectListing proj : projects) {
				toDelete = new ArrayList<>();
				
				for (Unit unit : proj.getUnitTypes()) {
					if (unit.getRoomType() != flatType) {
						toDelete.add(unit);
					}
				}
				
				for (int i=0; i<toDelete.size(); i++) {
					proj.removeUnitType(toDelete.get(i)); 
				}
			}
		}
		
		// filter all projects that fit criteria
		List<ProjectListing> filteredList = projects.stream()
				.filter(o -> o.getUnitTypes().size() > 0).collect(Collectors.toList());
		ArrayList<ProjectListing> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
