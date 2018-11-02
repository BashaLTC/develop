package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class CabBookingPage extends GenericWrappers {
	
	
	public CabBookingPage(RemoteWebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test = test;
	}
	
	
	public CabBookingPage switchToCabBookingPage(){
		switchToLastWindow();
		return this;
	}
	public CabBookingPage waitForElement(long time){
		explicitewait(time);
		return this;
	}
	public CabBookingPage clickOnWithPNR(){
		clickById("withPnr");
		return this;
	}
	public CabBookingPage enterPnrNo(String data){
		enterByName(objprop.getProperty("CabBookingPage.Cab.enterPnrNo"), data);
		return this;
	}
	public CabBookingPage clickOnSubmit(){
		clickById(objprop.getProperty("CabBookingPage.Cab.clickOnSubmit"));
		return this;
	}
	public CabBookingPage acceptTheAlert(){
		acceptAlert();
		return this;
	}
	public CabBookingPage clearText(){
		cleartextbyname(objprop.getProperty("CabBookingPage.Cab.clearText"));
		return this;
	}public CabBookingPage getTextFromAlert(){
		getAlertText();
		return this;
	}
	public CabBookingPage verifyAlertText(String textMessage){
		verifyTextFromAlert(textMessage);
		return this;
	}
//	public CabBookingPage clearTheText(){
//		clearText();
//		return this;
//	}
	public CabBookingPage clickOnWithoutPnr(){
		clickById(objprop.getProperty("CabPage.Cab.clickOnWithoutPnr"));
		return this;
	}
	public CabBookingPage selectCityName(String value){
		selectValueByName(objprop.getProperty("CabPage.Cab.selectCityName"), value);
		return this;
	}
	public CabBookingPage selectPickupStationCode(String value){
		selectValueByName(objprop.getProperty("CabPage.Cab.selectPickupStationCode"), value);
		return this;
	}
	public CabBookingPage selectPickupDate(){
		clickById(objprop.getProperty("CabPage.Cab.selectPickupDate1"));
		clickByXpath(objprop.getProperty("CabPage.Cab.selectPickupDate"));
		return this;
	}
	public CabBookingPage selectPickTimeHour(String value){
		selectValueByName(objprop.getProperty("CabPage.Cab.selectPickTimeHour"),value);
		return this;
	}
	public CabBookingPage selectPickTimeMin(String value){
		selectValueByName(objprop.getProperty("CabPage.Cab.selectPickTimeMin"), value);
		return this;
	}
	public CabBookingPage selectCab(){
		clickByName(objprop.getProperty("CabPage.Cab.selectCab"));
		return this;
	}
	public CabBookingPage selectCarClass(String value){
		selectvaluebyxpath(objprop.getProperty("CabPage.Cab.selectCarClass"), value);
		return this;
	}
	public CabBookingPage selectCarRoute(String value){
		selectValueById(objprop.getProperty("CabPage.Cab.selectCarRoute"), value);
		return this;
	}
	public CabBookingPage clickOnAgreeRoute(){
		clickById(objprop.getProperty("CabPage.Cab.clickOnAgreeRoute"));
		return this;
	}
	public CabBookingPage enterAddress(String data){
		enterByXpath(objprop.getProperty("CabPage.Cab.enterAddress"), data);
		return this;
	}
	public CabBookingPage clickOnAgree(){
		clickById(objprop.getProperty("CabPage.Cab.clickOnAgree"));
		return this;
	}
	public CabLoginPage clickOnProceed(){
		clickById(objprop.getProperty("CabPage.Cab.clickOnProceed"));
		return new CabLoginPage(driver, test);
	}
	
}
