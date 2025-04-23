package src.com.BTO.Model;
import java.util.ArrayList;

import src.com.BTO.Model.Enums.RoomType;

import java.time.LocalDate;

public class Project {
	// variable declaration
	private int id; // ID SHOULD BE SET WHEN SAVING/ LOADING
	private static int projCount = 0;
	
	private String projectName;
	private String neighbourhood;
	private LocalDate AppOpenDate;
	private LocalDate AppCloseDate;

    private HDBManager manager;
    private int officerCount;
    private ArrayList<HDBOfficer> officers = new ArrayList<HDBOfficer>();

    private ArrayList<Unit> unitTypes = new ArrayList<Unit>();
	
	private boolean visibility;
	
	// constructors
	public Project(String projName, String neighbourhood, 
					LocalDate appOpen, LocalDate appClose, 
					HDBManager manager){
		// Set dates with LocalDate.of( (INT)YEAR , (INT)MONTH , (INT)DATE );
		projectName = projName;
		this.neighbourhood = neighbourhood;
		
		AppOpenDate = appOpen;
		AppCloseDate = appClose;
		
		this.manager = manager;
		officerCount = 0;
		visibility = true;
	}
	
	// getters
	public int getID() { return id; }
	public static int getProjCount() { return projCount; }
	
	public String getProjectName() { return projectName; }
	public String getNeighbourhood() { return neighbourhood; } 
	public ArrayList<Unit> getUnitTypes() { return unitTypes; } 
	
	public LocalDate getAppOpenDate() { return AppOpenDate; }
	public LocalDate getAppCloseDate() { return AppCloseDate; }

	public HDBManager getManager() { return manager; }
	public ArrayList<HDBOfficer> getOfficers() { return officers; }
	public int getOfficerCount() { return officerCount; }
	
	public boolean getVisibility() { return visibility; }
	
	// setters
	public void setID() { setID(-1); }
	public void setID(int id) { 
		if (id == -1) this.id = projCount++;
		else this.id = id;
	}
	public static void setProjCount(int count) { projCount = count; }
	
	public void setProjectName(String newProjectName) { projectName = newProjectName; }
	public void setNeighbourhood(String newNeighbourhood) { neighbourhood = newNeighbourhood; }
	
	public void addUnitType(Unit newUnit) {
		for (Unit unit : unitTypes) {
			if (newUnit.getRoomType() == unit.getRoomType()) { // found, update newUnit values
				unit.setRoomType(newUnit.getRoomType());
				unit.setSellingPrice(newUnit.getSellingPrice());
				unit.setUnitCount(newUnit.getUnitCount());
				return;
			}
		}
		// unit does not exist
		unitTypes.add(newUnit);
	}
	public void removeUnitType(Unit oldUnit) {
		// make sure oldUnit exists
		boolean found = false;
		for (Unit unit : unitTypes) {
			if (oldUnit == unit) { // found, update newUnit values
				found = true;
				break;
			}
		}
		if (found) { unitTypes.remove(oldUnit); }
	}
	
	public void setAppOpenDate(LocalDate newOpenDate) { AppOpenDate = newOpenDate; }
	public void setAppCloseDate(LocalDate newCloseDate) { AppCloseDate = newCloseDate; }
	
	public void setManager(HDBManager newManager) { manager = newManager; }
	public void addOfficer(HDBOfficer newOfficer) { 
		officerCount++;
		officers.add(newOfficer);
	}
	public void removeOfficer(HDBOfficer oldOfficer) {
		boolean removed = officers.remove(oldOfficer);
		if (removed) officerCount--;
	}
	
	public void setVisibility(boolean vis) { visibility = vis; }
	
	// other methods
	@Override
    public String toString() {
        return "ProjectListing [name=" + projectName 
        		+ ",\n neighbourhood=" + neighbourhood 
        		+ ",\n units=" + unitTypes.toString() 
        		+ ",\n applicationOpen=" + AppOpenDate.toString()
        		+ ",\n applicationClose=" + AppCloseDate.toString()
        		+ ",\n manager IC=" + manager.toString()
        		+ "]";
    }
}
