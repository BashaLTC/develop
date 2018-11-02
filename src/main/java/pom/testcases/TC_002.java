package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC_002 extends ProjectWrappers{
	@BeforeClass
	public void setValues(){
		browserName="Chrome";
		testCaseName = "TC002";
		testCaseDescription ="Book Hotel";
		author = "Sabari";
		category = "smoke";
	}
	@Test
	public void bookHotel(){
		new HomePage(driver, test)
		.mouseHoverOnTourism()
		.mouseHoverOnStays()
		.mouseHoverOnLounge()
		.clickOnLounge()
		.switchToLoungePage()
		.selectCityName("New Delhi")
		.selectCheckInDate()
		.selectCheckOutDate()
		.selectCheckInTime("11")
		.selectCheckOutTime("11")
		.selectNoOfPersons("4")
		.checkAvaiability()
		.verifyTheText("Insufficient Availability... For The Given CheckInTime/CheckOutTime");		
	}

}
