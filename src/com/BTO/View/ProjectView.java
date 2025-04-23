package src.com.BTO.View;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;

import java.util.List;

public class ProjectView {
	public static void displayProject(Project proj) {
		System.out.println("--- Project information ---\n"
 				+ "Name: \t\t\t" + proj.getProjectName() + "\n"
				+ "Neighbourhood: \t\t" + proj.getNeighbourhood() + "\n"
				+ "Application Open: \t" + proj.getAppOpenDate() + "\n"
				+ "Application Close: \t" + proj.getAppCloseDate() + "\n"
		 		+ "Manager IC: \t\t" + proj.getManager().getName() + "\n");
		
		System.out.println("--- Unit information ---"); // MIGHT WANT TO HAVE A NICER UNIT PRINT LATER ON
		for (Unit unit : proj.getUnitTypes()) {
			System.out.println(unit);
		}
		System.out.println();
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
}
