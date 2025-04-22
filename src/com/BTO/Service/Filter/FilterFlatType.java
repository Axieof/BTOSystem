package src.com.BTO.Service.Filter;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;
import src.com.BTO.Model.Enums.RoomType;

public class FilterFlatType implements IFilterViewProject{
	private RoomType flatType = null;
	
	// set flat type to null if want no effect
	public void setFlatType(RoomType roomtype) { flatType = roomtype; }
	
	public ArrayList<Project> filter(ArrayList<Project> projects) {
		ArrayList<Unit> toDelete;
		
		// remove irrelevant flat types
		if(flatType != null) {
			for (Project proj : projects) {
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
		List<Project> filteredList = projects.stream()
				.filter(o -> o.getUnitTypes().size() > 0).collect(Collectors.toList());
		ArrayList<Project> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
