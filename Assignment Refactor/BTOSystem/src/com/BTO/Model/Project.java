package BTO.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;
    private String neighbourhood;
    private LocalDate appOpenDate;
    private LocalDate appCloseDate;

    private HDBManager manager;
    private List<HDBOfficer> officers = new ArrayList<>();
    private List<Unit> unitTypes = new ArrayList<>();

    private boolean visible = true;

    public Project(String projectName, String neighbourhood, LocalDate appOpenDate, LocalDate appCloseDate, HDBManager manager) {
        this.projectName = projectName;
        this.neighbourhood = neighbourhood;
        this.appOpenDate = appOpenDate;
        this.appCloseDate = appCloseDate;
        this.manager = manager;
    }

    // Getters
    public String getProjectName() { return projectName; }
    public String getNeighbourhood() { return neighbourhood; }
    public LocalDate getAppOpenDate() { return appOpenDate; }
    public LocalDate getAppCloseDate() { return appCloseDate; }
    public HDBManager getManager() { return manager; }
    public List<HDBOfficer> getOfficers() { return officers; }
    public List<Unit> getUnitTypes() { return unitTypes; }
    public boolean isVisible() { return visible; }

    // Setters
    public void addOfficer(HDBOfficer officer) { officers.add(officer); }
    public void addUnitType(Unit unit) { unitTypes.add(unit); }
    public void setVisibility(boolean visible) { this.visible = visible; }

    @Override
    public String toString() {
        return projectName + " (" + neighbourhood + ") from " +
                appOpenDate + " to " + appCloseDate + ", Units: " + unitTypes.size();
    }
}
