package src.com.BTO.Service;

import src.com.BTO.Controller.ApplicantEnquiryController;
import src.com.BTO.Controller.OfficerEnquiryController;
import src.com.BTO.Controller.OMEnquiryController;

public class OfficerEnquiryService {


    public void selectOptionsService(int enquiryChoice){
        OMEnquiryController callOMController = new OMEnquiryController();
        OfficerEnquiryController callOfficerController = new OfficerEnquiryController();
		ApplicantEnquiryController callAppController = new ApplicantEnquiryController();

        switch(enquiryChoice){
            case 0 -> callAppController.defaultEnquiryMessageController();
			case 1 -> callAppController.createEnquiryController();
			case 2 -> callAppController.viewProjectEnquiryController();
			case 3 -> callAppController.editEnquiryController();
			case 4 -> callAppController.deleteEnquiryController();
			case 5 -> callAppController.viewAnsweredController();
            case 6 -> callOMController.unansweredProjectEnquiryController();
            case 7 -> callOMController.answerEnquiryController();
            case 8 -> callOMController.deleteAnsweredEnquiryController();
			default -> callOfficerController.defaultEnquiryMessageController();
			}
			
		while (enquiryChoice !=0);
    }

}
