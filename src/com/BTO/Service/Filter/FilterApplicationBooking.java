package src.com.BTO.Service.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.com.BTO.Model.Application;
import src.com.BTO.Model.Enums.ApplicationStatus;

public class FilterApplicationBooking implements IFilterApplication{
	private boolean bookingRequested;
	
	public void setCondition(String req) { setCondition(Boolean.valueOf(req)); }
	public void setCondition(boolean b) { bookingRequested = b; }
	
	public ArrayList<Application> filter(ArrayList<Application> appls){
		List<Application> filteredList = appls.stream()
				.filter(o -> o.getReqBook() == bookingRequested).collect(Collectors.toList());
		ArrayList<Application> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
