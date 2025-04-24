package BTO.View;

public class HDBOfficerView extends ApplicantView {

    @Override
    public void displayOptions() {
        displayCommonOptions();
        System.out.println("2) View Projects");
        System.out.println("3) Apply/Book Project");
        System.out.println("4) View Your Applied Project");
        System.out.println("5) Request Application Withdrawal");
        System.out.println("6) Handle Your Enquiries");
        System.out.println("7) Register to Join Project");
        System.out.println("8) Manage Bookings");
        System.out.println("9) View Project and Enquiries");
    }
}