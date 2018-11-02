package pom.testcases;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import pom.pages.HomePage;

import wrappers.ProjectWrappers;

public class TC_001 extends ProjectWrappers{
	
	@BeforeClass
		public void setValues(){
			browserName="Chrome";
			testCaseName = "TC001";
			testCaseDescription ="IRCTC SignUp";
			author = "Sabari";
			category = "smoke";
					
	}
	@Test
	
	public void IRCTCSignup(){
		new HomePage(driver, test)
		.clickOnSignup()
		.enterUsername("girish")
		.enterPassword("testA222")
		.confirmPassword("testA222")
		.selectSecurityQuestion("0")
		.enterSecurityAnswer("rat")
		.selectLanguage("en")
		.enterFirstName("Gireesh")
		.enterMiddleName("Gudla")
		.enterLastName("Sabari")
		.chooseGenderMale()
		.selectMartialStatus()
		.selectDobDay("05")
		.selectDobMonth(1)
		.selectDobYear("1997")
		.selectOccupation("SelfEmployed")
		.enterUidNo("1265455564654")
		.enterPanNum("3215151151")
		.selectCountry("94")
		.enterEmail("maggie@gmail.com")
		.enterMobileNum("7548596485")
		.selectNationality("94")
		.enterAddress("6-164/a")
		.enterStreet("srikaklulam")
		.enterArea("srikaklulam")
		.enterPinCode("532440")
		.clickStatesName()
		.selectCityName(1)
		.selectPostOffice(15)
		.enterLandLine("08942225880")
		.clickResAndOff()
		.clickNewsLetter()
		.clickCommercialPromo()
		.clickIrctcSbiCard()
		.clickSubmit();
				
	}
}
