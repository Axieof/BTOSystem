package View;
import java.util.Scanner;

public class ApplicantView implements ILandingPageView{
	public void viewLandingPage() {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		while (choice != -1) {
			switch (choice) {
			case 1-> viewProjects();
			case 2-> 
			}
		}
	}
	
	public void viewProjects() {
		
	}
	
	public void applyProject() {
		
	}
	
	public void viewAppliedProject() {
		
	}
	
	public void requestAppWithdrawal() {
		
	}
	
	public void handleEnquiry() {
		
	}
}
