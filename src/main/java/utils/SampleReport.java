package utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReport {
@Test
	public void reporting(){
		
		ExtentReports report = new ExtentReports("./report/result1.html",true);
		ExtentTest test1 = report.startTest("TC001", "IRCTC SignUp");
		test1.assignAuthor("Sabari");
		test1.assignCategory("Functional");
		test1.log(LogStatus.PASS, "Invoke app", "The app is invoked");
		test1.log(LogStatus.PASS, "Click on signup", "Clicked on signup");
		test1.log(LogStatus.FAIL, "Click on signup", "not clicked on signup");
		report.endTest(test1);
		report.flush();
		//flush will write or update the test results to the report
	}

}
