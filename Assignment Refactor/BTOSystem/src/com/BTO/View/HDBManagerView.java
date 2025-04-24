package BTO.View;

public class HDBManagerView extends UserView {

    @Override
    public void displayOptions() {
        displayCommonOptions();
        System.out.println("2) Manage BTO Projects");
        System.out.println("3) Handle HDB Officer Registrations");
        System.out.println("4) Handle Applicant Applications");
        System.out.println("5) Handle Withdrawal Requests");
        System.out.println("6) View & Respond to Enquiries");
        System.out.println("7) Generate Reports");
    }
}