package src.com.BTO.Service;

import java.util.Scanner;

public class UserEnquiryService{
    Scanner sc = new Scanner(System.in);

    public int getInteger(){
        int tempInt = sc.nextInt();
        return tempInt;        
    }

    public String getString(){
        String tempString = sc.nextLine();
        return tempString; 
    }
}