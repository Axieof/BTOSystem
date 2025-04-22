package src.com.BTO.View;

import src.com.BTO.Model.Project;

public class HDBManagerView {

    public void displayMainMenu() {
        System.out.println("\n===== HDB MANAGER MAIN MENU =====");
        System.out.println("1) Manage BTO Projects");
        System.out.println("2) Handle HDB Officer Registrations");
        System.out.println("3) Handle Applicant Applications");
        System.out.println("4) Handle Withdrawal Requests");
        System.out.println("5) View & Respond to Enquiries");
        System.out.println("6) Generate Reports");
        System.out.println("0) Logout");
        System.out.print("Select an option: ");
    }

    public void displayProjectManagementMenu() {
        System.out.println("\n--- Project Management ---");
        System.out.println("1) Create New Project");
        System.out.println("2) Edit Existing Project");
        System.out.println("3) Delete a Project");
        System.out.println("4) Toggle Project Visibility");
        System.out.println("5) View All Projects");
        System.out.println("6) View My Projects Only");
        System.out.println("0) Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void displayOfficerMenu() {
        System.out.println("\n--- Officer Registration Management ---");
        System.out.println("1) View Pending Officer Registrations");
        System.out.println("2) Approve/Reject Officer Applications");
        System.out.println("0) Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void displayApplicantMenu() {
        System.out.println("\n--- Applicant Application Management ---");
        System.out.println("1) View All Applications");
        System.out.println("2) Approve/Reject Applications");
        System.out.println("0) Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void displayEnquiryMenu() {
        System.out.println("\n--- Enquiry Management ---");
        System.out.println("1) View All Enquiries");
        System.out.println("2) Respond to Enquiries (My Projects)");
        System.out.println("0) Back to Main Menu");
        System.out.print("Select an option: ");
    }

    public void showProjectCreated(Project p) {
        System.out.println("Project created: " + p.getProjectName());
    }

    public void showProjectEdited(Project p) {
        System.out.println("Project updated: " + p.getProjectName());
    }

    public void showProjectDeleted(Project p) {
        System.out.println("Project deleted: " + p.getProjectName());
    }

    public void showToggleVisibility(Project p, boolean visible) {
        System.out.println("Visibility for " + p.getProjectName() + " is now " + (visible ? "ON" : "OFF"));
    }

    public void showReportHeader(String type) {
        System.out.println("\n=== Generating Report (Filter: " + type.toUpperCase() + ") ===");
    }

    public void showInvalidOption() {
        System.out.println("Invalid choice. Please try again.");
    }

    public void showNoProjects() {
        System.out.println("No projects available.");
    }
}
