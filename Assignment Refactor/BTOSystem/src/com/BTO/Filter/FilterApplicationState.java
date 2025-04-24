package src.com.BTO.Service.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.com.BTO.Model.Application;
import src.com.BTO.Model.Enums.ApplicationStatus;

public class FilterApplicationState implements IFilterApplication{
	private ApplicationStatus status;
	
	public void setCondition(String status) {
		try {
			ApplicationStatus st;
			if (status.equals("NULL")) st = null;
			else st = ApplicationStatus.valueOf(status);
			setCondition(st);
		}
		catch (IllegalArgumentException e){
			System.out.println("ERROR: Invalid Status!");
		}
	}
	public void setCondition(ApplicationStatus s) { status = s; }
	
	public ArrayList<Application> filter(ArrayList<Application> appls){
		List<Application> filteredList = appls.stream()
				.filter(o -> o.getAppStatus() == status).collect(Collectors.toList());
		ArrayList<Application> filteredArrList = new ArrayList<>(filteredList);
		return filteredArrList;
	}
}
