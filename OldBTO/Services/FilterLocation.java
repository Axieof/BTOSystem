package src.com.BTO.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.com.BTO.Model.ProjectListing;

public class FilterLocation implements IFilterViewProject{
	private String location; 
	
	public void setLocation(String loc) { location = loc; }
	
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects) {
		List<ProjectListing> filteredList = projects.stream()
				.filter(o -> o.getNeighbourhood().equals(location)).collect(Collectors.toList());
		ArrayList<ProjectListing> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
