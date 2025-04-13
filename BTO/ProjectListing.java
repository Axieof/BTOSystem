package BTO;
import java.util.ArrayList;
import java.time.LocalDate;

public class ProjectListing {
	// variable declaration
	private String projectName;
	private String neighbourhood;
	private ArrayList<Unit> unitTypes = new ArrayList<Unit>();
	
	private LocalDate AppOpenDate;
	private LocalDate AppCloseDate;
	
	private HDBManager manager;
	private ArrayList<HDBOfficer> officers = new ArrayList<HDBOfficer>();
	private int officerCount;
	
	private boolean visibility;
	
	// constructors
	ProjectListing(String projName, String neighbourhood, 
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
	public void setProjectName(String newProjectName) { projectName = newProjectName; }
	public void setNeighbourhood(String newNeighbourhood) { neighbourhood = newNeighbourhood; }
	
	public void addUnitType(Unit newUnit) {
		// check if unit already exists in unitType
		for (int i=0; i<unitTypes.size(); i++) {

			// if yes, add to unitCount in the unitType
			if (newUnit.getRoomType() == unitTypes.get(i).getRoomType()) {
				unitTypes.get(i).setUnitCount(newUnit.getUnitCount() + unitTypes.get(i).getUnitCount());
				return;
			}
		}
		// else initialise and add newUnit to unitType
		unitTypes.add(newUnit);
		
	}
	public void removeUnitType(Unit oldUnit) {
		// make sure oldUnit exists
		for (int i=0; i<unitTypes.size(); i++) {

			if (oldUnit.getRoomType() == unitTypes.get(i).getRoomType()) {
				int newCount = oldUnit.getUnitCount() - unitTypes.get(i).getUnitCount();

				// if originally > removeCount, remove oldUnit entirely
				if (newCount <= 0) unitTypes.remove(i);

				// else subtract from unitCount
				else unitTypes.get(i).setUnitCount(newCount);
				return;
			}
		}
		// unit does not exist
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
