package src.com.BTO.Service.Filter;

import java.util.ArrayList;
import java.util.HashMap;

import src.com.BTO.Model.User;
import src.com.BTO.Model.Enums.ApplicationStatus;

import src.com.BTO.Model.Applicant;
import src.com.BTO.Model.HDBOfficer;
import src.com.BTO.Model.HDBManager;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Application;

public class FilterManager<T> {
	private <T>  ArrayList<T> prefFilter(ArrayList<T> items, User user, Class<? extends IFilterGeneral<T>> target){
		ArrayList<T> filtered = new ArrayList<>();
		HashMap<String, String> filters = user.getFilters();

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
	
	// Applicant, Officer, Manager Project Filter calls
	public ArrayList<Project> applFilterProjects(ArrayList<Project> projs, Applicant appl){
		ArrayList<Project> filtered;
    	
    	// FILTER THE COMPULSORY STUFF
    	filtered = callFilterVis(projs); // visibility
    	filtered = callFilterUserGrp(filtered, appl); // user group
    	
    	// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
    	filtered = prefFilter(filtered, appl, IFilterProject.class);
    	
    	return filtered;
	}
	
	public ArrayList<Project> offFilterProjects(ArrayList<Project> projs, HDBOfficer off){
		ArrayList<Project> filtered;
    	
    	// FILTER THE COMPULSORY STUFF
    	filtered = callFilterVis(projs); // visibility
    	
    	// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
    	filtered = prefFilter(filtered, off, IFilterProject.class);
    	
    	return filtered;
	}
	
	public ArrayList<Project> mgrFilterProjects(ArrayList<Project> projs, HDBManager mgr){
    	// FILTER THE COMPULSORY STUFF (None)
    	// THEN FILTER ACCORDING TO PREFERENCE (SHOULD BE STORED PER USER)
    	return prefFilter(projs, mgr, IFilterProject.class);
	}
	
	// Project filter methods
	public ArrayList<Project> callFilterVis(ArrayList<Project> projs) {
		FilterVisibility filterVis = new FilterVisibility();  
    	return filterVis.filter(projs);
	}
	public ArrayList<Project> callFilterUserGrp(ArrayList<Project> projs, Applicant appl) {
		FilterUserGroup filterGrp = new FilterUserGroup(); // user group
    	filterGrp.setCondition(appl);
    	return filterGrp.filter(projs);
	}
	
	// Officer, Manager application filter calls
	public ArrayList<Application> offManageApplication(ArrayList<Application> appls, HDBOfficer off){
		ArrayList<Application> filtered;
		
		// FILTER THE COMPULSORY STUFF
		FilterApplicationState filterState = new FilterApplicationState();  // application state
		filterState.setCondition(ApplicationStatus.SUCCESSFUL);
		filtered = filterState.filter(appls);
		
		// AND SHOULD FILTER FOR BOOKNG REQUESTED
		
		return filtered; // probably no need preference filter
	}
	public ArrayList<Application> mgrManageApplication(ArrayList<Application> appls){
		ArrayList<Application> filtered;
		
		// FILTER THE COMPULSORY STUFF
		FilterApplicationState filterState = new FilterApplicationState(); 
		filterState.setCondition(ApplicationStatus.PENDING);
		filtered = filterState.filter(appls);
		
		return filtered; // probably no need preference filter
	}
}
