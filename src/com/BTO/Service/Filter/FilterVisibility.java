package src.com.BTO.Service.Filter;
import java.util.List;

import java.util.ArrayList;
import java.util.stream.Collectors;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;

public class FilterVisibility implements IFilterProject{
	public ArrayList<Project> filter(ArrayList<Project> projects) {
		
		// Filter visibility off
		List<Project> filteredList = projects.stream()
				.filter(o -> o.getVisibility()).collect(Collectors.toList());
		ArrayList<Project> filteredArrList = new ArrayList<>(filteredList);
		
		ArrayList<Unit> toDelete; 
		
		// Remove units with 0 vacancy (should not be visible)
		for (Project proj : filteredArrList) {
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
