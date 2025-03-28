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
	
	private boolean visibility = true;
	
	// constructors
	
	
	// getters
	public String getProjectName() { return projectName; }
	public String getNeighbourhood() { return neighbourhood; } 
	public ArrayList<Unit> getUnitTypes() { return unitTypes; } 
	
	public String getAppOpenDate() { return AppOpenDate; }
	public String getAppCloseDate() { return AppCloseDate; }

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
	
	public void setVisibility(boolean vis) { visibility = vis; }
	
	// other methods
}
