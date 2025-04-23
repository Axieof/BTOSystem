package src.com.BTO.Service;

import src.com.BTO.Model.Enquiry;

public class OMEnquiryService {
    private Enquiry enquiry;
    
    public boolean validateRespondentService(int projectID){
        // check if project ID of manager/officer keyed in == found under their name
        return true;
    }

    public boolean unansweredProjectEnquiryService(int projectID){
        if (!validateRespondentService(projectID)){return false;}
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getProjectID() == projectID && enquiry.getResponse() == null){
                System.out.println(enquiry.toString());
                return true;
            }
        }
        return false;
    }


    public boolean answerEnquiryService(int projectID, String response){
        if (!validateRespondentService(projectID)){return false;}
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getProjectID() == projectID && enquiry.getResponse() == null){
                enquiry.setResponse(response);
                return true;}
        }
        return false;
    }
    

    public boolean deleteAnsweredEnquiryService(int projectID){
        if (!validateRespondentService(projectID)){return false;}
        for (Enquiry enquiry : enquiry.getAllEnquiry()){
            if (enquiry.getProjectID() == projectID && enquiry.getResponse() != null){
                enquiry.setResponse(null);
                return true;}
        }
        return false;
    }
    
}
