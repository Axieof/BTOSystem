package src.com.BTO.View;

public class OMEnquiryView {
    public void unansweredProjectEnquiryView(){
    System.out.println("Please key in the ProjectID of the project whose enquiry you would like to find：");
    }
    
    public void unansweredProjectEnquiryError(){
        System.out.println("Error! Project is not under you/There are no unanswered enquiries/There are no enquiries");
    }

    public void unansweredProjectEnquirySuccess(){
        System.out.println("List of unanswered enquiries: ");
    }

    public void deleteAnsweredEnquiryView(){
        System.out.println("Please key in the projectID of the project response you would like to remove");
    }

    public void deleteAnsweredEnquiryError(){
        System.out.println("Error!! ");
    }

    public void deleteAnsweredEnquirySuccess(){
        System.out.println("Successfully Deleted!");
    }

    public void answerEnquiryProjectView(){
        System.out.println("Enter the projectID of the project you would like to edit: ");
    }

    public void answerEnquiryResponseView(){
        System.out.println("Replaced Answer: ");
    }

    public void answerEnquiryResponseError(){
        System.out.println("Error!");
    }

    public void answerEnquiryResponseSuccess(){
        System.out.println("Successfully saved!");

    }
}
