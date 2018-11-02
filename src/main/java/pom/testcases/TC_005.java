package pom.testcases;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC_005 extends ProjectWrappers{
	@BeforeClass
	public void assignValues(){
		browserName="chrome";
	testCaseName = "TC005";
	testCaseDescription ="cabBookingWithoutPNR";
	author = "Sabari";
	category = "smoke";
}
	@Test
	public void cabBookingWithoutPNR(){
		new HomePage(driver, test)
		.mouseHoverOnTourism()
		.mouseHoverOnStays()
		.mouseHoverOnLounge()
		.clickOnLounge()
		.switchToLoungePage()
		.clickOnCab()
		.switchToCabBookingPage()
		.clickOnWithoutPnr()
		.waitForElement(2000)
		.selectCityName("BILASPUR")
		.selectPickupStationCode("BSP")
		.selectPickupDate()
		.selectPickTimeHour("11")
		.selectPickTimeMin("30")
		.selectCab()
		.selectCarClass("Small Segment")
		.selectCarRoute("Route B")
		.clickOnAgreeRoute()
		.enterAddress("area")
		.clickOnAgree()
		.clickOnProceed()
		.verifyTextFromLoginPage("Please Login To Continue…");
	}

}
