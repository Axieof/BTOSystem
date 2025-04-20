package src.com.BTO.Services;
import java.util.ArrayList;

import src.com.BTO.Model.ProjectListing;

public interface IFilterViewProject {
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects);
}
