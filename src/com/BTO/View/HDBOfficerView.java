package src.com.BTO.View;

public class HDBOfficerView extends ApplicantView{
	public void displayStarter() {
		System.out.println("--- Which menu? ---\n"
							+ "0) LOGOUT\n"
							+ "1) Applicant features\n"
							+ "2) Officer features\n"
							+ "3) View Project and Enquiries\n");
	}
	public void displayOptions() {
		System.out.println("--- Officer Options ---\n"
				+ "0) LOGOUT\n"
				+ "1) Register to join project\n"
				+ "2) Manage bookings\n"
				+ "3) Generate receipt\n");
	}
}
