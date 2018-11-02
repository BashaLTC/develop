package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrappers;

public class NVSPLoginPage extends ProjectWrappers{
	
	public NVSPLoginPage (RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test = test;
		
	}
	public NVSPLoginPage switchToNVSPPage(){
		switchToLastWindow();
		return this;
	}
	public NVSPRegistrationPage clickToApplyNVSP(){
		clickByLink(objprop.getProperty("NVSPPage.NVSP.clickToApplyNVSP"));
		return new NVSPRegistrationPage(driver, test);
	}

}
