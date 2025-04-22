package src.com.BTO.Service.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Class;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Applicant;

public class FilterProjectManager {
	public static ArrayList<Project> applFilterProjects(ArrayList<Project> projs, Applicant appl){
		ArrayList<Project> filtered;
    	
    	// FILTER THE COMPULSORY STUFF
    	FilterVisibility filterVis = new FilterVisibility();  // visibility
    	filtered = filterVis.filter(projs);
    	
    	FilterUserGroup filterGrp = new FilterUserGroup(); // user group
    	filterGrp.setCondition(appl);
    	filtered = filterGrp.filter(filtered);
    	
    	
    	// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
    	filtered = prefFilter(filtered, appl);
    	
    	return filtered;
	}
	
	private static ArrayList<Project> prefFilter(ArrayList<Project> projs, Applicant appl){
		ArrayList<Project> filtered = new ArrayList<>();
		HashMap<String, String> filters = appl.getFilters();

		try {
			for (String filtName : filters.keySet()) {
	    		Class<?> filterClass = Class.forName("src.com.BTO.Service.Filter." + filtName);
	    		IFilterViewProject filterObj = (IFilterViewProject) filterClass.getDeclaredConstructor().newInstance();    		
	    		
	    		if (filters.get(filtName) != "NULL") {
	    			filterObj.setCondition(filters.get(filtName));
		    		filtered = filterObj.filter(projs);
	    		}
	    	}
		}
		catch(ClassNotFoundException e) {
			System.out.println("ERROR: FilterObject not found!");
		}
		catch(Exception e) { System.out.println("ERROR!"); }
    	
    	
    	return filtered;
	}
}
