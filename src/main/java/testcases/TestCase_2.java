package testcases;

import org.testng.annotations.Test;

import utils.Data_input_provider1;
import wrappers.GenericWrappers;

public class TestCase_2 extends GenericWrappers{
	@Test(dataProvider="pullData",dataProviderClass=Data_input_provider1.class)
	public void Hotel_Booking (String cityName,String checkInTime,String checkOutTime,String noOfPax,String message){
	
	invokeApp("Chrome", "https://irctc.co.in");
	mouseHoverByXpath("//*[@id='bluemenu']/ul/li[2]/a");
	mouseHoverBylinktext("Stays");
	mouseHoverBylinktext("Lounge");
	clickByLink("Lounge");
	switchToLastWindow();
	selectValueByName("loungecityName", cityName);
	clickById("air_fromdate");
	clickByXpath("//*[@id='calbox']/table[1]/tbody/tr[6]/td[2]/a");
	clickById("air_fromdate1");
	clickByXpath("//*[@id='calbox']/table[1]/tbody/tr[6]/td[7]/a");
	selectValueByName("checkInTime", checkInTime);
	selectValueByName("checkOutTime", checkOutTime);
	selectValueByName("noOfPax", noOfPax);
	clickByName("chkAvl");
	verifyTextByXpath("//*[@id='centerbodyNewLook']/table/tbody/tr/td/b/font", message);
	//closeAllBrowsers();
}
}
