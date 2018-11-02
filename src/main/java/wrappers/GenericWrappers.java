package wrappers;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;


public class GenericWrappers extends Reporter implements Wrappers{

	public RemoteWebDriver driver;
	int i = 1;	

	protected static Properties objprop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	
	
	public GenericWrappers() {
		Properties configprop = new Properties();
		try {
			configprop.load(new FileInputStream(new File("./src/test/java/config.properties")));
			//sHubUrl = prop.getProperty("HUB");
			//sHubPort = prop.getProperty("PORT");
			sUrl = configprop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
   }

	
	
	public void invokeApp(String browser){
		invokeApp(browser, sUrl);
	}
	
	
	public void loadObjects() {
		objprop = new Properties();
		try {
			objprop.load(new FileInputStream(new File("./src/test/java/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		objprop = null;
	}
	
	
	
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64bit.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.internetexplorer.driver", "./drivers/internetexplorer.exe");
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			//System.out.println("The browser"+browser+" launched.");
			reportStep("The browser"+browser+" launched.", "pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser"+browser+"not launched due to unknown error");
			reportStep("The browser"+browser+"not launched due to unknown error","fail");
			
		}
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The element specified by the "+idValue+"Filled with correct input data" +data);
			reportStep("The element specified by the "+idValue+"Filled with correct input data" +data, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+idValue+"not found");
			reportStep("The Element specified by the "+idValue+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the"+idValue+"not visible");
			reportStep("The Element specified by the"+idValue+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("theElement specified by the"+idValue+"is in invalid state");
			reportStep("theElement specified by the"+idValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("The element specified by the "+nameValue+"Filled with correct input data" +data);
			reportStep("The element specified by the "+nameValue+"Filled with correct input data" +data, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+nameValue+"not found");
			reportStep("The Element specified by the "+nameValue+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the "+nameValue+"not visible");
			reportStep("The Element specified by the "+nameValue+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified by the"+nameValue+"is in invalid state");
			reportStep("The Element specified by the"+nameValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The element specified by the "+xpathValue+"Filled with correct input data");
			reportStep("The element specified by the "+xpathValue+"Filled with correct input data", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+xpathValue+"not found");
			reportStep("The Element specified by the "+xpathValue+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the "+xpathValue+"not visible");
			reportStep("The Element specified by the "+xpathValue+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified by the"+xpathValue+"is in invalid state");
			reportStep("The Element specified by the"+xpathValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			if ((driver.getTitle()).equals(title)){
				System.out.println("The titles are compared and they are matched");
			}else{
				System.out.println("The titles are compared and they are not matched");
			}
			//System.out.println("The title of the browser compared successfully");
			reportStep("The title of the browser compared successfully", "pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//System.err.println("the window got closed so unable to get title");
			reportStep("the window got closed so unable to get title", "fail");
		}catch (WebDriverException e){
			//System.err.println("the bowser got closed due to unkoown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementById(id).getText();
			if(actualtext.equals(text)){
				System.out.println("The element with"+id+" is matched with the expected text");
			}else{
				System.out.println("The element with"+id+" is not matched with the expected text");
			}
			//System.out.println("The text is verified successfully");
			reportStep("The text is verified successfully", "pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+id+" was not found");
			reportStep("The Element specified with "+id+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+id+" was not visible");
			reportStep("The Element specified with "+id+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with "+id+" is in invalid state");
			reportStep("The Element specified with "+id+" was not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			if(actualtext.equals(text)){
				System.out.println("the element with"+xpath+" is matched with the expected text");
			}else{
				System.err.println("the element with"+xpath+" is not matched with the expected text");
			}
			//System.out.println("The text is verified successfully");
			reportStep("The text is verified successfully", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpath+" was not found");
			reportStep("The Element specified with "+xpath+" was not found" ,"fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpath+" was not visible");
			reportStep("The Element specified with "+xpath+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+xpath+"is in invalid state");
			reportStep("The Element specified with"+xpath+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			if(actualtext.contains(text)){
				System.out.println("the element with"+xpath+" is matched with the expected text");
			}else{
				System.out.println("the element with"+xpath+" is matched with the expected text");
			}
			//System.out.println("The text is verified successfully");
			reportStep("The text is verified successfully", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpath+" was not found");
			reportStep("The Element specified with "+xpath+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpath+" was not visible");
			reportStep("The Element specified with "+xpath+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("the"+xpath+"is invalid state");
			reportStep("the"+xpath+"is invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			//System.out.println("The element specified with"  +id+"is clicked successfully");
			reportStep("The element specified with"  +id+"is clicked successfully", "pass",false);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+id+" was not found");
			reportStep("The Element specified with "+id+" was not found", "fail",false);
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+id+" was not visible");
			reportStep("The Element specified with "+id+" was not visible", "fail",false);
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with "+id+" is in invalid state");
			reportStep("The Element specified with "+id+" is in invalid state", "fail",false);
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail",false);
		}
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			//System.out.println("The element specified with"  +classVal+"is clicked successfully");
			reportStep("The element specified with"  +classVal+"is clicked successfully", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+classVal+" was not found");
			reportStep("The Element specified with "+classVal+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+classVal+" was not visible");
			reportStep("The Element specified with "+classVal+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with "+classVal+"is in invalid state");
			reportStep("The Element specified with "+classVal+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			//System.out.println("The element specified with"  +name+"is clicked successfully");
			reportStep("The element specified with"  +name+"is clicked successfully", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+name+" was not found");
			reportStep("The Element specified with "+name+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+name+" was not visible");
			reportStep("The Element specified with "+name+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+name+" is in invalid state");
			reportStep("The Element specified with"+name+" is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}
	

	public void clickByNameNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			//System.out.println("The element specified with"  +name+"is clicked successfully");
			reportStep("The element specified with"  +name+"is clicked successfully", "pass",false);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+name+" was not found");
			reportStep("The Element specified with "+name+" was not found", "fail",false);
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+name+" was not visible");
			reportStep("The Element specified with "+name+" was not visible", "fail",false);
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+name+" is in invalid state");
			reportStep("The Element specified with"+name+" is in invalid state", "fail",false);
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail",false);
		}
	}

	
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element specified with"  +name+"is clicked successfully");
			reportStep("The element specified with"  +name+"is clicked successfully", "pass");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+name+" was not found");
			reportStep("The Element specified with "+name+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+name+" was not visible");
			reportStep("The Element specified with "+name+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+name+"is in invalid state");
			reportStep("The Element specified with"+name+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element specified with"  +name+"is clicked successfully");
			reportStep("The element specified with"  +name+"is clicked successfully", "pass");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+name+" was not found");
			reportStep("The Element specified with "+name+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+name+" was not visible");
			reportStep("The Element specified with "+name+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+name+"is in invalid state");
			reportStep("The Element specified with"+name+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element specified with"  +xpathVal+"is clicked successfully");
			reportStep("The element specified with"  +xpathVal+"is clicked successfully", "pass");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpathVal+" was not found");
			reportStep("The Element specified with "+xpathVal+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpathVal+" was not visible");
			reportStep("The Element specified with "+xpathVal+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+xpathVal+"is in invalid state");
			reportStep("The Element specified with"+xpathVal+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element specified with"  +xpathVal+"is clicked successfully");
			reportStep("The element specified with"  +xpathVal+"is clicked successfully", "pass");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpathVal+" was not found");
			reportStep("The Element specified with "+xpathVal+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpathVal+" was not visible");
			reportStep("The Element specified with "+xpathVal+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+xpathVal+"is in invalid state");
			reportStep("The Element specified with"+xpathVal+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		try {
			String gettext = driver.findElementById(idVal).getText();
			//System.out.println("got this"+ gettext);
			reportStep("got this"+ gettext, "pass");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The "+idVal+"not found");
			reportStep("The "+idVal+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The "+idVal+"not visible");
			reportStep("The "+idVal+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The element specified with"+idVal+"is in invalid state");
			reportStep("The element specified with"+idVal+"is in invalid state", "fail");
		}
		catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		return null;
		
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			String gettext =  driver.findElementByXPath(xpathVal).getText();
			//System.out.println("Got this "+gettext+"from xPath");
			reportStep("Got this "+gettext+"from xPath", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpathVal+" was not found");
			reportStep("The Element specified with "+xpathVal+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+xpathVal+" was not visible");
			reportStep("The Element specified with "+xpathVal+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The element specified with"+xpathVal+"is in invalid state");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			Select sel1 = new Select(driver.findElementById(id));
			sel1.selectByValue(value);
			//System.out.println("the element Specified" +value+ " has been selected from the dropdown");
			reportStep("the element Specified" +value+ " has been selected from the dropdown", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The "+value+"not found");
			reportStep("The "+value+"not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+value+" was not visible");
			reportStep("The Element specified with "+value+" was not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fAil");
		}
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			Select sel2 = new Select(driver.findElementById(id));
			sel2.selectByIndex(value);
			//System.out.println("the element Specified" +value+ " has been selected from the dropdown");
			reportStep("the element Specified" +value+ " has been selected from the dropdown", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+value+" was not found");
			reportStep("The Element specified with "+value+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+value+" was not visible");
			reportStep("The Element specified with "+value+" was not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> winid = driver.getWindowHandles();
			System.out.println(winid);
			for(String allids : winid){
				driver.switchTo().window(allids);
				break;
			}
			//System.out.println("The focus is switched to parent window");
			reportStep("The focus is switched to parent window", "true");
			
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//System.err.println("No Such window is there to switch");
			reportStep("No Such window is there to switch", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> winid = driver.getWindowHandles();
			System.out.println(winid);
			for(String allids : winid){
				driver.switchTo().window(allids);
			}
			//System.out.println("The focus is switched to last window");
			reportStep("The focus is switched to last window", "pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//System.err.println("No Such Window is found to switch");
			reportStep("No Such Window is found to switch", "fail");
			
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			//System.out.println(" Alert is available and it was accepted");
			reportStep("Alert is available and it was accepted", "pass",false);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("There is no alert available to accept");
			reportStep("There is no alert available to accept","fail",false);
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unkown error", "fail",false);
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			//System.out.println("Alert is avilable and it was dismissed");
			reportStep("Alert is avilable and it was dismissed", "pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("There is no alert available to dismiss");
			reportStep("There is no alert available to dismiss", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unkown error", "fail");
		}
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		try {
			String gettext = driver.switchTo().alert().getText();
			System.out.println("the text from alert is "+ gettext);
			reportStep("the text from alert is "+ gettext, "pass",false);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.out.println("Their is no alert to get text");
			reportStep("Their is no alert to get text", "fail",false);
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unkown error");
			reportStep("The browser got closed due to unkown error", "fail",false);
		}
		return null;
	}

//	public void takeSnap() {
//		// TODO Auto-generated method stub
//		try {
//			File pic =  driver.getScreenshotAs(OutputType.FILE);
//			File dest = new File("./Screenshots/shot"+i+".jpeg");
//			FileUtils.copyFile(pic, dest);
//			System.out.println("captured successfully");
//		} 
//		catch (WebDriverException e) {
//			// TODO Auto-generated catch block
//			System.err.println("The browser got closed because of unknown error ");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//		}
//		i++;
//	}

	public void closeBrowserNoSnap() {
		// TODO Auto-generated method stub
	 try {
		driver.close();
		//System.out.println("Active window got closed");
		reportStep("Active window got closed", "pass",false);
	} catch (NoSuchWindowException e) {
		// TODO Auto-generated catch block
		//System.err.println("Target Window already closed");
		reportStep("Target Window already closed", "fail",false);
	}catch (WebDriverException e){
		//System.err.println("The Browser got closed because of unknown error");
		reportStep("The Browser got closed because of unknown error", "fail",false);
	}
	}
	

	public void closeAllBrowsersNoSnap() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			//System.out.println("Browser got closed");
			reportStep("Browser got closed", "pass",false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Browser got closed because of unknown error");
			reportStep("The Browser got closed because of unknown error", "fail",false);
		} 
	}

	public void selectValueById(String id, String value) {
		try {
			Select sel = new Select(driver.findElementById(id));
			sel.selectByValue(value);
			//System.out.println("The Element specified with value"+value+"hasbeen selected from dropdown");
			reportStep("The Element specified with value"+value+"hasbeen selected from dropdown", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("No Such Element is available to select");
			reportStep("No Such Element is available to select", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("Element is not visible");
			reportStep("Element is not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The Browser got closed due to unknown error");
			reportStep("The Browser got closed due to unknown error", "fail");
		}
	}

	public void mouseHoverById(String id) {
		// TODO Auto-generated method stub
		try {
			WebElement Tourism = driver.findElementById(id);
			Actions move = new Actions(driver);
			move.moveToElement(Tourism).perform();
			//System.out.println("MoverHover on the specified element"+id+" is successfull");
			reportStep("MoverHover on the specified element"+id+" is successfull", "pass");
		} catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the"+id+"is not visible to MouseHover");
			reportStep("The Element specified by the"+id+"is not visible to MouseHover", "fail");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+id+" was not found");
			reportStep("The Element specified with "+id+" was not found", "fail");
		}
		catch (InvalidElementStateException e){
			//System.err.println("The Element specified by the"+id+"is in invalid state");
			reportStep("The Element specified by the"+id+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
		
	}

	public void mouseHoverByXpath(String xpathValue) {
		// TODO Auto-generated method stub
		try {
			WebElement Tourism = driver.findElementByXPath(xpathValue);
			Actions move = new Actions(driver);
			move.moveToElement(Tourism).perform();
			//System.out.println("MoverHover on the specified element"+xpathValue+" is successfull");
			reportStep("MoverHover on the specified element"+xpathValue+" is successfull", "pass");
			
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the"+xpathValue+" is not visible to MouseHover");
			reportStep("The Element specified by the"+xpathValue+" is not visible to MouseHover", "fail");
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+xpathValue+" was not found");
			reportStep("The Element specified with "+xpathValue+" was not found", "fail");
		}
		catch (InvalidElementStateException e){
			//System.err.println("theElement specified by the"+xpathValue+"is in invalid state");
			reportStep("theElement specified by the"+xpathValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void mouseHoverBylinktext(String linkValue) {
		// TODO Auto-generated method stub
		try {
			WebElement Tourism = driver.findElementByLinkText(linkValue);
			Actions move = new Actions(driver);
			move.moveToElement(Tourism).perform();
			//System.out.println("MoverHover on the specified element"+linkValue+" is successfull");
			reportStep("MoverHover on the specified element"+linkValue+" is successfull", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+linkValue+" was not found");
			reportStep("The Element specified with "+linkValue+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+linkValue+" was not visible");
			reportStep("The Element specified with "+linkValue+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+linkValue+"is in invalid state");
			reportStep("The Element specified with"+linkValue+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
		
	}

	public void selectVisibileTextByName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			Select sel = new Select(driver.findElementByName(name));
			sel.selectByVisibleText(value);
			//System.out.println("The Element specified with value"+value+"hasbeen selected from dropdown");
			reportStep("The Element specified with value"+value+"hasbeen selected from dropdown", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("No Such Element is available to select");
			reportStep("No Such Element is available to select", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("Element is not visible");
			reportStep("Element is not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The Browser got closed due to unknown error");
			reportStep("The Browser got closed due to unknown error", "fail");
		}
	}

	public void selectValueByName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			Select sel = new Select(driver.findElementByName(name));
			sel.selectByValue(value);
			//System.out.println("The Element specified with value"+value+" selected from dropdown");
			reportStep("The Element specified with value"+value+" selected from dropdown", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("No Such Element is available to select");
			reportStep("No Such Element is available to select", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("Element is not visible");
			reportStep("Element is not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The Browser got closed due to unknown error");
			reportStep("The Browser got closed due to unknown error", "fail");
		}
	}

	public void selectIndexByName(String name, int value) {
		// TODO Auto-generated method stub
		try {
			Select sel = new Select(driver.findElementByName(name));
			sel.selectByIndex(value);
			//System.out.println("The Element specified with value"+value+"has selected from dropdown");
			reportStep("The Element specified with value"+value+"has selected from dropdown", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("No Such Element is available to select");
			reportStep("No Such Element is available to select", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("Element is not visible");
			reportStep("Element is not visible", "fail");
		}catch (WebDriverException e){
			//System.err.println("The Browser got closed due to unknown error");
			reportStep("The Browser got closed due to unknown error", "fail");
		}
		
	}

	public void uploadFileByid(String path, String Id)   {
		// TODO Auto-generated method stub
		try {
			Clipboard copy = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection copy1 = new StringSelection(path);
			copy.setContents(copy1, null);
			driver.findElementById(Id).click();
			Thread.sleep(4000);
			System.out.println(copy1);
			Robot obj = new Robot();
			obj.keyPress(KeyEvent.VK_CONTROL);
			obj.keyPress(KeyEvent.VK_V);
			obj.keyRelease(KeyEvent.VK_V);
			obj.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3500);
			obj.keyPress(KeyEvent.VK_ENTER);
			obj.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3500);
			//System.out.println("The file hasbeen uploaded successfully from the specified path");
			reportStep("The file hasbeen uploaded successfully from the specified path", "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified with "+Id+" was not found");
			reportStep("The Element specified with "+Id+" was not found", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified with "+Id+" was not visible");
			reportStep("The Element specified with "+Id+" was not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("The Element specified with"+Id+"is in invalid state");
			reportStep("The Element specified with"+Id+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}catch (AWTException e){
			
		} catch (InterruptedException e) {
			
		}		
		
	}

	public void pressTabById(String Id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(Id).sendKeys(Keys.TAB);
			//System.out.println("Tab operation performed successfully on the specified element"+Id);
			reportStep("Tab operation performed successfully on the specified element"+Id, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element specified by the "+Id+"is not found to perform Tab operation");
			reportStep("The Element specified by the "+Id+"is not found to perform Tab operation", "fail");
		}catch (ElementNotVisibleException e){
			//System.err.println("The Element specified by the"+Id+"not visible");
			reportStep("The Element specified by the"+Id+"not visible", "fail");
		}catch (InvalidElementStateException e){
			//System.err.println("theElement specified by the"+Id+"is in invalid state");
			reportStep("theElement specified by the"+Id+"is in invalid state", "fail");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
	
		}

	public void cleartextbyname(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).clear();
			//System.out.println("The text cleared from the specified "+name);
			reportStep("The text cleared from the specified "+name, "pass");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The specified element"+name+ "is not visible to clear the text");
			reportStep("The specified element"+name+ "is not visible to clear the text", "false");
		}catch(ElementNotFoundException e){
			//System.out.println("The specified element"+name+"is not found to clear the text");
			reportStep("The specified element"+name+"is not found to clear the text", "false");
		}catch(WebDriverException e){
			//System.out.println("The browser got closed because of unkown error");
			reportStep("The browser got closed because of unkown error", "false");
		}
		
	}

	public void selectvaluebyxpath(String xpath, String value) {
		// TODO Auto-generated method stub
		try {
			Select sel1 = new Select (driver.findElementByXPath(xpath));
			sel1.selectByValue(value);
			//System.out.println("The element Specified with value " +value+ " hasbeen selected from the dropdown");
			reportStep("The element Specified with value " +value+ " hasbeen selected from the dropdown", "PASS");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element spesified with "+value+"was not found");
			reportStep("The element spesified with "+value+"was not found", "fail");
		}catch (ElementNotVisibleException e){
			reportStep("The Element specified with "+value+" was not visible", "fail");
			//System.err.println("The Element specified with "+value+" was not visible");
		}catch (WebDriverException e){
			//System.err.println("The browser got closed due to unknown error");
			reportStep("The browser got closed due to unknown error", "fail");
		}
			
		}

	public void explicitewait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void verifyTextFromAlert(String textMessage){
		try {
			String msg = driver.switchTo().alert().getText();
			if(msg.equals(textMessage)){
				System.out.println("Acutal text from the alert is verified and they are matched ");
			}else{
				System.out.println("Acutal text from the alert is verified and they are not matched ");
			}
			//System.out.println("Test message from Alert is verified");
			reportStep("Test message from Alert is verified", "PASS",false);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("No such Alert is available");
			reportStep("No such Alert is available", "FAIL",false);
		}
	}


	public long takeSnap() {
		long number=1000000l;
		// TODO Auto-generated method stub
		try {
			number=(long)Math.floor(Math.random()*10000000)+1000000l;
			File pic =  driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./reports/images/"+number+".jpeg");
			FileUtils.copyFile(pic, dest);
			//reportStep("Captured Successfully", "PASS");
		} 
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser got closed because of unknown error ");
			//reportStep("The browser got closed because of unknown error ", "fail");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}	
		return number;
	}



	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}



	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		
	}
		
}
