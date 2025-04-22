package src.com.BTO.View;

import src.com.BTO.Model.Project;
import src.com.BTO.Model.Unit;

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
}
