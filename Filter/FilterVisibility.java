package Filter;
import BTO.ProjectListing;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterVisibility implements IFilterViewProject{
	public ArrayList<ProjectListing> filter(ArrayList<ProjectListing> projects) {
		List<ProjectListing> filteredList = projects.stream()
				.filter(o -> o.getVisibility()).collect(Collectors.toList());
		ArrayList<ProjectListing> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
