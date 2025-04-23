package src.com.BTO.Model;

import src.com.BTO.Model.Enums.ApplicationStatus;

public class WithdrawalApplication {
	public Application withdrawing;
	private ApplicationStatus status;
	
	public WithdrawalApplication(Application a) { 
		withdrawing = a; 
		status = ApplicationStatus.PENDING;
	}
	
	public void setApplicationStatus(ApplicationStatus stat) { status = stat; }
	public ApplicationStatus getApplicationStatus() { return status; }
}
