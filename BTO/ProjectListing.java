package BTO;
import java.util.ArrayList;

public class ProjectListing {
	// variable declaration
	private String projectName;
	private String neighbourhood;
	private ArrayList<Unit> unitTypes = new ArrayList<Unit>();
	
	private String AppOpenDate;
	private String AppCloseDate;
	
	private HDBManager manager;
	private ArrayList<HDBOfficer> officers = new ArrayList<HDBOfficer>();
	private int officerCount;
	
	// getters
	public String getProjectName() { return projectName; }
	// still considering if neighbourhood should be enum or class(I dont think so) or string (most likely?)
	public String getNeighbourhood() { return neighbourhood; } 
	public ArrayList<Unit> getUnitTypes() { return unitTypes; } 
	
	public String getAppOpenDate() { return AppOpenDate; }
	public String getAppCloseDate() { return AppCloseDate; }

	public HDBManager getManager() { return manager; }
	public ArrayList<HDBOfficer> getOfficers() { return officers; }
	public int getOfficerCount() { return officerCount; }
	
	// setters
	public void setProjectName(String newProjectName) { projectName = newProjectName; }
	public void setNeighbourhood(String newNeighbourhood) { neighbourhood = newNeighbourhood; }
	
	public void addUnitType(Unit newUnit, int count) {
		// check if unit already exists in unitType
		// if yes, add to unitCount in the unitType
		// else initialise and add newUnit to unitType
	}
	public void removeUnitType(Unit oldUnit, int count) {
		// make sure oldUnit exists
		// if originally > removeCount, remove oldUnit entirely
		// else subtract from unitCount
	}
	
	public void setAppOpenDate(String newOpenDate) { AppOpenDate = newOpenDate; }
	public void setAppCloseDate(String newCloseDate) { AppCloseDate = newCloseDate; }
	
	public void setManager(HDBManager newManager) { manager = newManager; }
	public void addOfficer(HDBOfficer newOfficer) { 
		officerCount++;
		officers.add(newOfficer);
	}
	public void removeOfficer(HDBOfficer oldOfficer) {
		// get officer name
		// loop through officers list and delete oldOfficer
	}
	
	// other methods
}
