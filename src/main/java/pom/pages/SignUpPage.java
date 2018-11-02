package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class SignUpPage extends GenericWrappers{
	
	
	public SignUpPage(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	
	public SignUpPage enterUsername(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterUsername"), data);
		return this;
	}
	public SignUpPage enterPassword(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterPassword"), data);
		return this;
	}
	public SignUpPage confirmPassword(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.confirmPassword"), data);
		return this;
	}
	public SignUpPage selectSecurityQuestion(String value){
		selectValueById(objprop.getProperty("SignUpPage.SignUp.selectSecurityQuestion"), value);
		return this;
	}
	public SignUpPage enterSecurityAnswer(String value){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterSecurityAnswer"), value);
		return this;
	}
	public SignUpPage selectLanguage(String value){
		selectValueById(objprop.getProperty("SignUpPage.SignUp.selectLanguage"), value);
		return this;
	}
	public SignUpPage enterFirstName(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterFirstName"), data);
		return this;
	}
	public SignUpPage enterMiddleName(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterMiddleName"), data);
		return this;
	}
	public SignUpPage enterLastName(String data ){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterLastName"), data);
		return this;
	}
	public SignUpPage chooseGenderMale(){
		clickById(objprop.getProperty("SignUpPage.SignUp.chooseGenderMale"));
		return this;
	}
	public SignUpPage chooseGenderFemale(){
		clickById(objprop.getProperty("SignUpPage.SignUp.chooseGenderFemale"));
		return this;
	}
	public SignUpPage chooseGenderTransgender(){
		clickById(objprop.getProperty("SignUpPage.SignUp.chooseGenderTransgender"));
		return this;
	}
	public SignUpPage selectMartialStatus(){
		clickById(objprop.getProperty("SignUpPage.SignUp.selectMartialStatus"));
		return this;
	}
	public SignUpPage selectDobDay(String value){
		selectValueById(objprop.getProperty("SignUpPage.SignUp.selectDobDay"), value);
		return this;
	}
	public SignUpPage selectDobMonth(int value){
		selectIndexById(objprop.getProperty("SignUpPage.SignUp.selectDobMonth"), value);
		return this;
	}
	public SignUpPage selectDobYear(String value){
		selectValueById(objprop.getProperty("SignUpPage.SignUp.selectDobYear"), value);
		return this;
	}
	public SignUpPage selectOccupation(String value){
		selectVisibileTextById(objprop.getProperty("SignUpPage.SignUp.selectOccupation"), value);
		return this;
	}
	public SignUpPage enterUidNo(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterUidNo"), data);
		return this;
	}
	public SignUpPage enterPanNum(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterPanNum"), data);
		return this;
	}
	public SignUpPage selectCountry(String value){
		selectVisibileTextById(objprop.getProperty("SignUpPage.SignUp.selectCountry"), value);
		return this;
	}
	public SignUpPage enterEmail(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterEmail"), data);
		return this;
	}
	public SignUpPage enterMobileNum(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterMobileNum"), data);
		return this;
	}
	public SignUpPage selectNationality(String value){
		selectValueById(objprop.getProperty("SignUpPage.SignUp.selectNationality"), value);
		return this;
	}
	public SignUpPage enterAddress(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterAddress"), data);
		return this;
	}
	public SignUpPage enterStreet(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterStreet"), data);
		return this;
	}
	public SignUpPage enterArea(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterArea"), data);
		return this;
	}
	public SignUpPage enterPinCode(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterPinCode"), data);
		return this;
	}
	public SignUpPage clickStatesName(){
		clickById(objprop.getProperty("SignUpPage.SignUp.clickStatesName"));
		return this;
	}
	public SignUpPage selectCityName(int value){
		selectIndexById(objprop.getProperty("SignUpPage.SignUp.selectCityName"), value);
		return this;
	}
	public SignUpPage waitForElement(long time){
		explicitewait(time);
		return this;
	}
	public SignUpPage selectPostOffice(int value){
		selectIndexById(objprop.getProperty("SignUpPage.SignUp.selectPostOffice"), value);
		return this;
	}
	public SignUpPage enterLandLine(String data){
		enterById(objprop.getProperty("SignUpPage.SignUp.enterLandLine"), data);
		return this;
	}
	public SignUpPage clickResAndOff(){
		clickById(objprop.getProperty("SignUpPage.SignUp.clickResAndOff"));
		return this;
	}
	public SignUpPage clickNewsLetter(){
		clickById(objprop.getProperty("SignUpPage.SignUp.clickNewsLetter"));
		return this;
	}
	public SignUpPage clickCommercialPromo(){
		clickById(objprop.getProperty("SignUpPage.SignUp.clickCommercialPromo"));
		return this;
	}
	public SignUpPage clickIrctcSbiCard(){
		clickById(objprop.getProperty("SignUpPage.SignUp.clickIrctcSbiCard"));
		return this;
	}
	public SignUpPage clickSubmit(){
		clickByNameNoSnap(objprop.getProperty("SignUpPage.SignUp.clickSubmit"));
		return this;
	}
}
	
