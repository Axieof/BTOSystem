package BTO.View;

public abstract class UserView {

    public void displayCommonOptions() {
        System.out.println("0) Logout");
        System.out.println("1) Personal Settings");
    }

    public abstract void displayOptions();
}