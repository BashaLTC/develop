package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC_003 extends ProjectWrappers{
	@BeforeClass
	public void setValues(){
		browserName="Chrome";
		testCaseName = "TC001";
		testCaseDescription ="NVSP Registration";
		author = "Sabari";
		category = "smoke";
	}
	@Test
	public void nvspRegistration (){
		new HomePage(driver,test)
		.mouseHoverOnMore()
		.mouseHoverOnNVSP()
		.clickOnNvsp()
		.switchToNVSPPage()
		.clickToApplyNVSP()
		.selectLanguage("en-GB")
		.selectState("S01")
		.selectDistrict("Srikakulam")
		.selectConstituency("10")
		.clickShiftingConstituency()
		.enterName("Sabari")
		.enterSurname("Gudla")
		.enterRelativename("Harish")
		.enterRelativeurname("chidere")
		.selectRelationType("G")
		.clickOnRbdDateOfBirth()
		.enterDOB("31071997")
		.selectApplicantGender("M")
		.enterApplicantHouseNo("4-164/a")
		.enterApplicantStreet("vishya nagar colony")
		.enterApplicantVillage("Achampet")
		.enterApplicantPostOffice("Achampet")
		.selectApplicantDistrict("1")
		.clickOnPermanent()
		.enterApplicantEpicNo("2565245215")
		.clickOnVisualDisability()
		.enterApplicantEmail("Sabarui123@gmail.com")
		.enterApplicantMobile("785965485")
		.uploadPhotograph("C:\\Users\\sabar\\Downloads\\Pic.jpg")
		.selectAgeProof("IDProoflist")
		.uploadAgeProof("C:\\Users\\sabar\\Downloads\\IMG-20180115-WA0043.jpg")
		.selectAddressProof("AddressProoflist")
		.uploadAddressProof("C:\\Users\\sabar\\Downloads\\IMG-20180115-WA0043.jpg")
		.enterApplicantBirthVillage("Achampet")
		.selectApplicantPreState("applicantBirthState")
		.waitForTheElement(3000)
		.selectApplicantPreDistrict("applicantBirthDistrict")
		.enterApplicantPreHouseNo("4-164/a")
		.enterApplicantPreStreet("vishya nagar colony")
		.enterApplicantPreVillage("Achampet")
		.enterApplicantPrePostOffice("Achampet")
		.enterApplicantPrePincode("509375")
		.enterApplicantFormPlace("Achampet");
	
	}

}
