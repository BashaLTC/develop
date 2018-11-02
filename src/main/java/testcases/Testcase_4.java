package testcases;



import org.testng.annotations.Test;

import utils.Data_input_provider3;
import wrappers.GenericWrappers;

public class Testcase_4 extends GenericWrappers{
	@Test(dataProvider="fetchData",dataProviderClass=Data_input_provider3.class)
	public void IRCTC_Cab_withPNR (String pnrNumber,String textMessage) throws InterruptedException{
		
		invokeApp("chrome", "https://irctc.co.in");
		mouseHoverByXpath("//*[@id='bluemenu']/ul/li[2]/a/img");
		mouseHoverBylinktext("Stays");
		mouseHoverBylinktext("Lounge");
		clickByLink("Lounge");
		switchToLastWindow();
		clickByXpath("//*[@id='main-menu']/li[6]/a");
		Thread.sleep(2000);
		switchToLastWindow();
		enterByName("pnrNumber", pnrNumber);
		clickById("submit_button");
		verifyTextFromAlert(textMessage);
		acceptAlert();
		cleartextbyname("pnrNumber");
		Thread.sleep(3000);
		clickById("submit_button");
		Thread.sleep(3000);
		closeAllBrowsers();

		
	}
	
	

	}

