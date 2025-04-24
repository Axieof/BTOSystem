package BTO.View;

public class ApplicantView extends UserView {

    @Override
    public void displayOptions() {
        displayCommonOptions();
        System.out.println("2) View Projects");
        System.out.println("3) Apply/Book Project");
        System.out.println("4) View Your Applied Project");
        System.out.println("5) Request Application Withdrawal");
        System.out.println("6) Handle Your Enquiries");
    }
}