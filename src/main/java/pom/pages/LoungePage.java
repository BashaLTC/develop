package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungePage extends GenericWrappers{
	
	public LoungePage(RemoteWebDriver driver, ExtentTest test){

		this.driver = driver;
		this.test=test;
	}
	
	public LoungePage switchToLoungePage(){
		switchToLastWindow();
		return this;
	}
	public LoungePage selectCityName(String value){
		selectValueByName(objprop.getProperty("LoungePage.BookHotel.selectCityName"), value);
		return this;
	}
	
	public LoungePage fromDate(){
		clickById("air_fromdate");
		return this;
	}
	public LoungePage selectCheckInDate(){
		clickById(objprop.getProperty("LoungePage.BookHotel.selectCheckInDate1"));
		clickByXpath(objprop.getProperty("LoungePage.BookHotel.selectCheckInDate"));
		return this;
	}
	public LoungePage selectCheckOutDate(){
		clickById(objprop.getProperty("LoungePage.BookHotel.selectCheckOutDate1"));
		clickByXpath(objprop.getProperty("LoungePage.BookHotel.selectCheckOutDate"));
		return this;
	}
	public LoungePage selectCheckInTime(String value){
		selectValueByName(objprop.getProperty("LoungePage.BookHotel.selectCheckInTime"), value);
		return this;
	}
	public LoungePage selectCheckOutTime(String value){
		selectValueByName(objprop.getProperty("LoungePage.BookHotel.selectCheckOutTime"), value);
		return this;
	}
	public LoungePage selectNoOfPersons(String value){
		selectValueByName(objprop.getProperty("LoungePage.BookHotel.selectNoOfPersons"), value);
		return this;
	}
	public LoungePage checkAvaiability(){
		clickByName(objprop.getProperty("LoungePage.BookHotel.checkAvaiability"));
		return this;
	}
	public LoungePage verifyTheText(String text){
		verifyTextByXpath(objprop.getProperty("LoungePage.BookHotel.verifyTheText"), text);
		return null;
	}
	public CabBookingPage clickOnCab(){
		clickByXpath(objprop.getProperty("LoungePage.Cab.clickOnCab"));
		return new CabBookingPage(driver, test);
	}

}
