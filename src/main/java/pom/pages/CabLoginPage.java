package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class CabLoginPage extends GenericWrappers{
	
		public CabLoginPage(RemoteWebDriver driver, ExtentTest test){
			
			this.driver= driver;
			this.test= test;
		}
		
	public CabLoginPage verifyTextFromLoginPage(String text){
		verifyTextByXpath(objprop.getProperty("CabPage.Cab.verifyTextFromLoginPage"), text);
		return this;
	}
}
