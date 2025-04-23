package src.com.BTO.View;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;

import java.util.List;
import java.util.ArrayList;

public class ProjectView {
	public void displayProject(Project proj) {
		displayPureProject(proj);
		
		int count = 1;
		for (Unit unit : proj.getUnitTypes()) {
			displayUnit(unit, count);
			count += 1;
		}
		System.out.println();
    }
	
	public void displayPureProject(Project proj) {
		System.out.println("--- Project information ---\n"
 				+ "Name: \t\t\t" + proj.getProjectName() + "\n"
				+ "Neighbourhood: \t\t" + proj.getNeighbourhood() + "\n"
				+ "Application Open: \t" + proj.getAppOpenDate() + "\n"
				+ "Application Close: \t" + proj.getAppCloseDate() + "\n"
		 		+ "Manager IC: \t\t" + proj.getManager().getName() + "\n");
	}

	public void displayProjectNames(ArrayList<Project> projects) {
		Project proj;
	   	for (int i=0; i<projects.size(); i++) {
	   		proj = projects.get(i);
	   		if (proj.getVisibility()) {
	   			System.out.println(i + ". " + proj.getProjectName());
	   		}
	   	}
	}

    public void displayProjectList(List<Project> projects) {
        System.out.println("===== All Project Listings =====");

        for (Project project : projects) {
            System.out.println("\nProject: " + project.getProjectName());
            System.out.println("Location: " + project.getNeighbourhood());
            System.out.println("Application Period: " +
                    project.getAppOpenDate() + " to " + project.getAppCloseDate());
            System.out.println("Managed by: " + project.getManager().getName());

            System.out.println("Units Available:");
            for (Unit unit : project.getUnitTypes()) {
                System.out.println(" - " + unit.getRoomType() +
                        ": " + unit.getUnitCount() +
                        " units @ $" + unit.getSellingPrice());
            }

            System.out.println("Assigned Officers:");
            project.getOfficers().forEach(officer ->
                    System.out.println(" - " + officer.getName()));

            System.out.println("Visible to Applicants: " + (project.getVisibility() ? "Yes" : "No"));
            System.out.println("--------------------------------------------------");
        }

        System.out.println("===== End of Project List =====\n");
    }
    
    public void displayUnit(Unit u) { displayUnit(u, -1); }
    public void displayUnit(Unit u, int i) {
    	if (i >= 0) {
    		System.out.println("--- Unit " + i + " information ---\n"
     				+ "Unit Type: \t\t\t" + u.getRoomType() + "\n"
    				+ "Selling Price: \t\t" + u.getSellingPrice() + "\n");
    	}
    	else {
    		System.out.println("--- Unit information ---\n"
     				+ "Unit Type: \t" + u.getRoomType() + "\n"
    				+ "Selling Price: \t" + u.getSellingPrice() + "\n");
    	}
    }
}
