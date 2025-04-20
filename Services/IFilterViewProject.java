package Services;
import BTO.ProjectListing;
import java.util.ArrayList;

public interface IFilterViewProject {
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects);
}
