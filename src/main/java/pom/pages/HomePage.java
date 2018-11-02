package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
	
	public HomePage(RemoteWebDriver driver, ExtentTest test){
	
		this.driver=driver;
		this.test=test;
	}
	
	public HomePage enterUserId(String data){
		enterById(objprop.getProperty("HomePage.UserName.id"), data);
		return this;
	}
	public SignUpPage clickOnSignup(){
		
		clickByLink(objprop.getProperty("HomePage.SignUp.Link"));
		return new SignUpPage(driver, test);
	}
	public HomePage mouseHoverOnTourism(){
		mouseHoverByXpath(objprop.getProperty("HomePage.BookHotel.mouseHoverOnTourism"));
		return this;
	}
	public HomePage mouseHoverOnStays(){
		mouseHoverBylinktext(objprop.getProperty("HomePage.BookHotel.mouseHoverOnStays"));
		return this;
	}
	public HomePage mouseHoverOnLounge(){
		mouseHoverBylinktext(objprop.getProperty("HomePage.BookHotel.mouseHoverOnLounge"));
		return this;
	}
	public HomePage mouseHoverOnMore(){
		mouseHoverByXpath(objprop.getProperty("HomePage.NVSP.mouseHoverOnMore"));
		return this;
	}
	public HomePage mouseHoverOnNVSP(){
		mouseHoverByXpath(objprop.getProperty("HomePage.NVSP.mouseHoverOnNVSP"));
		return this;
	}
	public NVSPLoginPage clickOnNvsp(){
		clickByLink(objprop.getProperty("HomePage.NVSP.clickOnNvsp"));
		return new NVSPLoginPage(driver, test);
	}
	public LoungePage clickOnLounge(){
		clickByLink(objprop.getProperty("HomePage.BookHotel.clickOnLounge"));
		return new LoungePage(driver, test);
	}
}
	
