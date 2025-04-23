package src.com.BTO.Service;

import src.com.BTO.Controller.OMEnquiryController;
import src.com.BTO.Model.Enquiry;
import src.com.BTO.Controller.ApplicantEnquiryController;
import src.com.BTO.Controller.ManagerEnquiryController;

public class ManagerEnquiryService {
    private Enquiry enquiry;
    OMEnquiryController callOMController = new OMEnquiryController();
    ManagerEnquiryController callManagerController = new ManagerEnquiryController();
    ApplicantEnquiryController callAppController = new ApplicantEnquiryController();

    public void selectOptionsService(int enquiryChoice){

        switch(enquiryChoice){
            case 0 -> callManagerController.defaultEnquiryMessageController();
			case 1 -> callAppController.viewProjectEnquiryController();
			case 2 -> callOMController.unansweredProjectEnquiryController();
			case 3 -> callOMController.answerEnquiryController();
			case 4 -> callOMController.deleteAnsweredEnquiryController();
			case 5 -> callManagerController.viewAllEnquiryController();
			default -> callManagerController.defaultEnquiryMessageController();
			} while (enquiryChoice !=0);
        }


    public boolean viewAllEnquiryService(){
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
                System.out.println(enquiry.toString());
        }
        return true;
    
    }
}
