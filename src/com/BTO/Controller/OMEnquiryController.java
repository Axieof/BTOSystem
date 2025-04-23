package src.com.BTO.Controller;

import src.com.BTO.Service.OMEnquiryService;
import src.com.BTO.View.OMEnquiryView;
import src.com.BTO.Service.UserEnquiryService;


public class OMEnquiryController {
    OMEnquiryView callView = new OMEnquiryView();
    OMEnquiryService callService = new OMEnquiryService();
    UserEnquiryService callUserService = new UserEnquiryService();

    
    public void unansweredProjectEnquiryController(){

        callView.unansweredProjectEnquiryView();
        int projectID = callUserService.getInteger();
        if (!callService.unansweredProjectEnquiryService(projectID)){callView.unansweredProjectEnquiryError();}
        else{callView.unansweredProjectEnquirySuccess();}
    }


    public void deleteAnsweredEnquiryController(){
        callView.deleteAnsweredEnquiryView();
        int projectID = callUserService.getInteger();
        if (!callService.deleteAnsweredEnquiryService(projectID)){callView.deleteAnsweredEnquiryError();}
        else{callView.deleteAnsweredEnquirySuccess();}

    }

    public void answerEnquiryController(){
        callView.answerEnquiryProjectView();
        int projectID = callUserService.getInteger();
        callView.answerEnquiryResponseView();
        String response = callUserService.getString();
        if (!callService.answerEnquiryService(projectID, response)){callView.answerEnquiryResponseError();}
        else{callView.answerEnquiryResponseSuccess();}
    }


}