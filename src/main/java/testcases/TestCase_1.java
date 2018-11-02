package testcases;

import java.io.FileInputStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Data_input_provider;
import wrappers.GenericWrappers;

public class TestCase_1 extends GenericWrappers{

	@Test(dataProvider="fetchData",dataProviderClass=Data_input_provider.class)
	public void irctcsignup(String userName,String password,String confpasword,String SecurityQ,String securityAnswer,String prelan,String firstName,String middleName,String lastName,String dobDay,
			String dobMonth,String dateOfBirth,String occupation,String uidno,String idno,String countries,String email,String mobile,String nationalityId,String address,String street,String area,String pincode,
			String cityName,String postofficeName,String landline) throws InterruptedException{
				
		invokeApp("Chrome", "https://irctc.co.in");
		clickByLink("Sign up");
		enterById("userRegistrationForm:userName", userName);
		enterById("userRegistrationForm:password", password);
		enterById("userRegistrationForm:confpasword", confpasword);
		selectValueById("userRegistrationForm:securityQ", SecurityQ);
		enterById("userRegistrationForm:securityAnswer", securityAnswer);
		selectValueById("userRegistrationForm:prelan", prelan);
		enterById("userRegistrationForm:firstName", firstName);
		enterById("userRegistrationForm:middleName", middleName);
		enterById("userRegistrationForm:lastName", lastName);
		clickById("userRegistrationForm:gender");
		clickById("userRegistrationForm:maritalStatus");
		selectValueById("userRegistrationForm:dobDay", dobDay);
		selectIndexById("userRegistrationForm:dobMonth",Integer.parseInt(dobMonth) );
		selectVisibileTextById("userRegistrationForm:dateOfBirth", dateOfBirth);
		selectVisibileTextById("userRegistrationForm:occupation", occupation);
		enterById("userRegistrationForm:uidno", uidno);
		enterById("userRegistrationForm:idno", idno);
		selectVisibileTextById("userRegistrationForm:countries", countries);
		enterById("userRegistrationForm:email", email);
		enterById("userRegistrationForm:mobile", mobile);
		selectValueById("userRegistrationForm:nationalityId", nationalityId);
		enterById("userRegistrationForm:address", address);
		enterById("userRegistrationForm:street", street);
		enterById("userRegistrationForm:area", area);
		enterById("userRegistrationForm:pincode", pincode);
		pressTabById("userRegistrationForm:pincode");
		//selectIndexById("userRegistrationForm:cityName", 0);
		selectIndexById("userRegistrationForm:cityName",Integer.parseInt(cityName));
        Thread.sleep(1000);
        selectIndexById("userRegistrationForm:postofficeName",Integer.parseInt(postofficeName));
        enterById("userRegistrationForm:landline", landline);
        clickById("userRegistrationForm:newsletter");
        clickById("userRegistrationForm:commercialpromo");
        clickById("userRegistrationForm:irctcsbicard:1");
        clickById("userRegistrationForm:j_idt502");
        dismissAlert();
        closeAllBrowsers();
        
		
	}
		
	
	
	

}


