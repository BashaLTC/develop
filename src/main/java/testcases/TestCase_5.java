package testcases;



import org.testng.annotations.Test;

import utils.Data_input_provider;
import utils.Data_input_provider4;
import wrappers.GenericWrappers;

public class TestCase_5 extends GenericWrappers{
	@Test(dataProvider="FetchData",dataProviderClass=Data_input_provider4.class)
	public void IRCTC_cab_WithoutPNR (String cityName,String pickupstationCode,String pickTimeHour,String pickTimeMin,
			String CarClass, String carRoute, String Text, String message) throws InterruptedException {
		
		
		invokeApp("chrome", "https://irctc.co.in");
		mouseHoverByXpath("//*[@id='bluemenu']/ul/li[2]/a/img");
		mouseHoverBylinktext("Stays");
		clickByLink("Lounge");
		switchToLastWindow();
		clickByXpath("//*[@id='main-menu']/li[6]/a");
		switchToLastWindow();
		clickById("withoutPnr");
		selectValueByName("cityName", cityName);
		selectValueByName("pickupstationCode", pickupstationCode);
		Thread.sleep(3000);
		clickByXpath("//*[@id='pickDate']");
		clickByXpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[6]/a");
		selectValueByName("pickTimeHour", pickTimeHour);
		selectValueByName("pickTimeMin", pickTimeMin);
		clickByName("radio1");
		selectvaluebyxpath("//*[@id='carId']/select", CarClass);
		Thread.sleep(3000);
		selectValueById("carRoute", carRoute);
		clickById("ch1");
		enterByXpath("//*[@id='dropAddress']/td[2]/textarea", Text);
		clickById("ch2");
		clickById("CheckAvlRoom");
		//getTextByXpath("//*[@id='login']/div/span[1]/span/div[1]/div/table/tbody/tr/td/b/font");
		verifyTextByXpath("//*[@id='login']/div/span[1]/span/div[1]/div/table/tbody/tr/td/b/font", message);
		
		
	}

}
