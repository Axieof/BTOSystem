package src.com.BTO.Service.Filter;

import java.util.ArrayList;
import java.util.HashMap;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.Project;

public class FilterManager<T> {
	private static <T> ArrayList<T> prefFilter(ArrayList<T> items, Applicant appl, Class<? extends IFilterGeneral<T>> target){
		ArrayList<T> filtered = new ArrayList<>();
		HashMap<String, String> filters = appl.getFilters();

		try {
			for (String filtName : filters.keySet()) {
	    		Class<?> filterClass = Class.forName("src.com.BTO.Service.Filter." + filtName);
	    		IFilterGeneral<T> filterObj = (IFilterGeneral) filterClass.getDeclaredConstructor().newInstance();    		
	    		
	    		// Check valid filter + applicable filter
	    		if (target.isInstance(filterObj)) {
	    			filterObj.setCondition(filters.get(filtName));
		    		filtered = filterObj.filter(items);
	    		}
	    	}
		}
		catch(ClassNotFoundException e) {
			System.out.println("ERROR: FilterObject not found!");
		}
		catch(Exception e) { System.out.println("ERROR!"); }
    	
    	
    	return filtered;
	}
	
	public static ArrayList<Project> filterProjects(ArrayList<Project> projs, Applicant appl){
		ArrayList<Project> filtered;
    	
    	// FILTER THE COMPULSORY STUFF
    	FilterVisibility filterVis = new FilterVisibility();  // visibility
    	filtered = filterVis.filter(projs);
    	
    	FilterUserGroup filterGrp = new FilterUserGroup(); // user group
    	filterGrp.setCondition(appl);
    	filtered = filterGrp.filter(filtered);
    	
    	// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
    	filtered = prefFilter(filtered, appl, IFilterProject.class);
    	
    	return filtered;
	}
}
