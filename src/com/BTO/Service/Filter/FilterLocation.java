package src.com.BTO.Service.Filter;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import src.com.BTO.Model.Project;

public class FilterLocation implements IFilterViewProject{
	private String location; 
	
	public void setCondition(String loc) { location = loc; }
	
	public ArrayList<Project> filter(ArrayList<Project> projects) {
		List<Project> filteredList = projects.stream()
				.filter(o -> o.getNeighbourhood().equals(location)).collect(Collectors.toList());
		ArrayList<Project> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
