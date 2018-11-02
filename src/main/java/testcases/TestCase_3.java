package testcases;



import org.testng.annotations.Test;

import utils.Data_input_provider2;
import wrappers.GenericWrappers;

public class TestCase_3 extends GenericWrappers{
	@Test(dataProvider="GetData",dataProviderClass=Data_input_provider2.class)
	public void NVSP_form (String language,String stateList,String distList,String acList,String applicantName,String applicantSurname,
			String applicantFMHName,String applicantFMHSurname, String applicantRelationType, String transposedPersonResidingSinceYear,
			String transposedPersonResidingSinceMonth,String txtDateOfBirth,String elector_gender,String applicantPresentHouseNo,String applicantPresentStreet,
			String applicantPresentVillage,String applicantPresentPostoffice, String applicantPresentPincode, String applicantFamilyPrevepicno, String applicantEmail,
			String applicantMobile, String applicantBirthVillage,String applicantBirthState,String applicantBirthDistrict, String txtRESIDENT_SINCE, String applicantFormPlace,
			String preState, String preDistrict, String preConstituency, String applicantPreHouseNo, String applicantPreStreet, String applicantPreVillage,
			String applicantPrePostoffice,String applicantPrePincode) throws InterruptedException{
		invokeApp("chrome", "http://IRCTC.co.in");
		mouseHoverByXpath("//*[@id='bluemenu']/ul/li[6]/a/img");
		mouseHoverByXpath("National Voter's Services Portal");
		clickByLink("National Voter's Services Portal");
		switchToLastWindow();
		Thread.sleep(8000);
		clickByLink("Click here");
		selectValueById("language", language);
		selectValueById("stateList", stateList);
		selectVisibileTextById("distList", distList);
		selectValueById("acList", acList);
		clickById("isExistingVoter");
		clickById("isNewVoter");
		enterById("applicantName", applicantName);
		enterById("applicantSurname", applicantSurname);
		enterById("applicantFMHName", applicantFMHName);
		enterById("applicantFMHSurname", applicantFMHSurname);
		selectValueById("applicantRelationType",(applicantRelationType));
//		selectValueById("transposedPersonResidingSinceYear", transposedPersonResidingSinceYear);
//		selectVisibileTextById("transposedPersonResidingSinceMonth", transposedPersonResidingSinceMonth);
		clickById("RbdDateOfBirth");
		enterById("txtDateOfBirth", txtDateOfBirth);
		selectValueById("elector_gender", elector_gender);
		enterById("applicantPresentHouseNo", applicantPresentHouseNo);
		enterById("applicantPresentStreet", applicantPresentStreet);
		enterById("applicantPresentVillage", applicantPresentVillage);
		enterById("applicantPresentPostoffice", applicantPresentPostoffice);
		enterById("applicantPresentPincode", applicantPresentPincode);
		clickById("chkPermanent");
		enterById("applicantFamilyPrevepicno", applicantFamilyPrevepicno);
		enterById("applicantEmail", applicantEmail);
		enterById("applicantMobile", applicantMobile);
		uploadFileByid("‪C:\\Users\\sabar\\Downloads\\Pic.jpg", "applicant_photo_image");
		selectValueById("IDProoflist", "1");
		uploadFileByid("C:\\Users\\sabar\\Downloads\\IMG-20180115-WA0043.jpg", "applicant_identity_image");
		selectValueById("AddressProoflist", "3");
		uploadFileByid("C:\\Users\\sabar\\Downloads\\IMG-20180115-WA0043.jpg", "applicant_address_image");
		enterById("applicantBirthVillage", applicantBirthVillage);
//		selectValueById("applicantBirthState", applicantBirthState);
//		selectValueById("applicantBirthDistrict", applicantBirthDistrict);
//		enterById("txtRESIDENT_SINCE", txtRESIDENT_SINCE);
		selectValueById("ddPrevState", preState);
		selectValueById("PREV_DISTRICT_NO", preDistrict);
		selectValueById("ddPrevac", preConstituency);
		enterById("applicantPreHouseNo", applicantPreHouseNo);
		enterById("applicantPreStreet", applicantPreStreet);
		enterById("applicantPreVillage", applicantPreVillage);
		enterById("applicantPrePostoffice", applicantPrePostoffice);
		enterById("applicantPrePincode", applicantPrePincode);
		enterById("applicantFormPlace", applicantFormPlace);
		
		//clickById("submit_button_store_id");
	}
}
