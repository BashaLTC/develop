package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC_004 extends ProjectWrappers {
	@BeforeClass
		public void assignValues(){
		browserName="chrome";
		testCaseName = "TC004";
		testCaseDescription ="bookCabWithPNR";
		author = "Sabari";
		category = "smoke";
	}
	@Test
	public void bookCabWithPNR(){
		new HomePage(driver, test)
		.mouseHoverOnTourism()
		.mouseHoverOnStays()
		.mouseHoverOnLounge()
		.clickOnLounge()
		.switchToLoungePage()
		.clickOnCab()
		.switchToCabBookingPage()
		.waitForElement(3000)
		.enterPnrNo("1234567890")
		.clickOnSubmit()
		.waitForElement(2000)
		.getTextFromAlert()
		.verifyAlertText("Please Enter Valid Pnr Number.")
		.acceptTheAlert()
		.waitForElement(2000)
		.clearText()
		.clickOnSubmit()
		.getTextFromAlert()
		.verifyAlertText("Please Enter Pnr Number.")
		.acceptTheAlert();
	}

}
