package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class NVSPRegistrationPage extends GenericWrappers {
	
	public NVSPRegistrationPage(RemoteWebDriver driver , ExtentTest  test){
		this.driver=driver;
		this.test=test;
		
	}
	
	public NVSPRegistrationPage selectLanguage(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectLanguage"), value);
		return this;
	}
	public NVSPRegistrationPage selectState(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectState"), value);
		return this;
	}
	public NVSPRegistrationPage selectDistrict(String value){
		selectVisibileTextById(objprop.getProperty("NVSPRegPage.NVSP.selectDistrict"), value);
		return this;
	}
	public NVSPRegistrationPage selectConstituency(String value){
		selectValueById("NVSPRegPage.NVSP.selectConstituency", value);
		return this;
	}
	public NVSPRegistrationPage clickShiftingConstituency(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.clickShiftingConstituency"));
		return this;
	}
	public NVSPRegistrationPage clickOnFirstVoter(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.NVSPRegistrationPage"));
		return this;
	}
	public NVSPRegistrationPage enterName(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterName"), data);
		return this;
	}
	public NVSPRegistrationPage enterSurname(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterSurname"), data);
		return this;
	}
	public NVSPRegistrationPage enterRelativename(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterRelativename"), data);
		return this;
	}
	public NVSPRegistrationPage enterRelativeurname(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterRelativeurname"), data);
		return this;
	}
	public NVSPRegistrationPage selectRelationType(String data){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectRelationType"), data);
		return this;	
	}
	public NVSPRegistrationPage selectTransposedPersonResidingSinceYear(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectTransposedPersonResidingSinceYear"), value);
		return this;
	}
	public NVSPRegistrationPage selectTransposedPersonResidingSinceMonth(String value){
		selectVisibileTextById(objprop.getProperty("NVSPRegPage.NVSP.selectTransposedPersonResidingSinceMonth"), value);
		return this;
	}
	public NVSPRegistrationPage clickOnRbdDateOfBirth(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.clickOnRbdDateOfBirth"));
		return this;
	}
	public NVSPRegistrationPage enterDOB(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterDOB"), data);
		return this;
	}
	public NVSPRegistrationPage selectApplicantGender(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectApplicantGender"), value);
		return this;
	}
	public NVSPRegistrationPage enterApplicantHouseNo(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantHouseNo"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantStreet(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantStreet"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantVillage(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantVillage"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantPostOffice(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantPostOffice"), data);
		return this;
	}
//	public NVSPRegistrationPage enterApplicantPincode(String data){
//		enterById("applicantPresentPincode", data);
//		return this;
//	}
//	public NVSPRegistrationPage selectApplicantState(String value){
//		selectValueById("ddCurrentST_CODE", value);
//		return this;
//	}
	public NVSPRegistrationPage selectApplicantDistrict(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectApplicantDistrict"), value);
		return this;
	}
	public NVSPRegistrationPage clickOnPermanent(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.clickOnPermanent"));
		return this;
	}
	public NVSPRegistrationPage enterApplicantEpicNo(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantEpicNo"), data);
		return this;	
	}
	public NVSPRegistrationPage clickOnVisualDisability(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.clickOnVisualDisability"));
		return this;
	}
	public NVSPRegistrationPage clickOnSpeechDisability(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.clickOnSpeechDisability"));
		return this;
	}
	public NVSPRegistrationPage clickOnLocomotorDisability(){
		clickById(objprop.getProperty("NVSPRegPage.NVSP.clickOnLocomotorDisability"));
		return this;
	}
	public NVSPRegistrationPage enterOtherDisability(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterOtherDisability"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantEmail(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantEmail"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantMobile(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantMobile"), data);
		return this;
	}
	public NVSPRegistrationPage uploadPhotograph(String path){
		uploadFileByid(path, objprop.getProperty("NVSPRegPage.NVSP.uploadPhotograph"));
		return this;
	}
	public NVSPRegistrationPage selectAgeProof(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectAgeProof"), value);
		return this;
	}
	public NVSPRegistrationPage uploadAgeProof(String path){
		uploadFileByid(path, objprop.getProperty("NVSPRegPage.NVSP.uploadAgeProof"));
		return this;
	}
	public NVSPRegistrationPage selectAddressProof(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectAddressProof"), value);
		return this;
	}
	public NVSPRegistrationPage uploadAddressProof(String path){
		uploadFileByid(path,objprop.getProperty("NVSPRegPage.NVSP.uploadAddressProof"));
		return this;
	}
	public NVSPRegistrationPage enterApplicantBirthVillage(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantBirthVillage"), data);
		return this;
	}
	public NVSPRegistrationPage selectApplicantBirthState(String data){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectApplicantBirthState"), data);
		return this;
	}
	public NVSPRegistrationPage selectApplicantBirthDistrict(String data){
		selectValueById("NVSPRegPage.NVSP.selectApplicantBirthDistrict", data);
		return this;
	}
	public NVSPRegistrationPage enterResidentSince(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterResidentSince"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantFormPlace(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantFormPlace"), data);
		return this;
	}
	public NVSPRegistrationPage waitForTheElement(long time){
		explicitewait(time);
		return this;
	}
	public NVSPRegistrationPage selectApplicantPreState(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectApplicantPreState"), value);
		return this;
	}
	public NVSPRegistrationPage selectApplicantPreDistrict(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectApplicantPreDistrict"), value);
		return this;
	}
	public NVSPRegistrationPage selectPreConstituency(String value){
		selectValueById(objprop.getProperty("NVSPRegPage.NVSP.selectPreConstituency"), value);
		return this;
	}
	public NVSPRegistrationPage enterApplicantPreHouseNo(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantPreHouseNo"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantPreStreet(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantPreStreet"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantPreVillage(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantPreVillage"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantPrePostOffice(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantPrePostOffice"), data);
		return this;
	}
	public NVSPRegistrationPage enterApplicantPrePincode(String data){
		enterById(objprop.getProperty("NVSPRegPage.NVSP.enterApplicantPrePincode"), data);
		return this;
	}

}
