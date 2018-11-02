package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	//here we are declaring the class as abstract because we are declaring the method(abstract method) in the class.
	
	public ExtentTest test;
	public static ExtentReports report;
	public String testCaseName,testCaseDescription,author,category;
	
	public void reportStep(String desc, String status){
		
		long snapNumber = 100000l;
		try {
			snapNumber = takeSnap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//write if it successful, failure or information
		if(status.toUpperCase().equals("PASS"))
			{
				test.log(LogStatus.PASS, desc+test.addScreenCapture("./../reports/images/"+snapNumber+".jpeg"));	
			}
		else if (status.toUpperCase().equals("FAIL"))
			{
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("./../reports/images/"+snapNumber+".jpeg"));
			}
		else if (status.toUpperCase().equals("INFO"))
			{
			test.log(LogStatus.INFO, desc);
			}
		else if (status.toUpperCase().equals("WARN"))
			{
			test.log(LogStatus.WARNING, desc+test.addScreenCapture("./../reports/images/"+snapNumber+".jpeg"));
			}
	}
	
	public void reportStep(String desc,String status,boolean snap){
		
		if(snap==false){
			if(status.toUpperCase().equals("PASS"))
			{
				test.log(LogStatus.PASS, desc);	
			}
		else if (status.toUpperCase().equals("FAIL"))
			{
			test.log(LogStatus.FAIL, desc);
			}
		else if (status.toUpperCase().equals("INFO"))
			{
			test.log(LogStatus.INFO, desc);
			}
		else if (status.toUpperCase().equals("WARN"))
			{
			test.log(LogStatus.WARNING, desc);
			}
	}
		}
		
	

	public abstract long takeSnap() ;
	
	public ExtentReports startReport(){
		
		report = new ExtentReports("./reports/result2.html",false);
		return report;
	}
	public ExtentTest startTest (String testCaseName,String testCaseDescription){
		test= report.startTest(testCaseName, testCaseDescription);
		return test;
	}
	public void endReport(){
		report.flush();
	}
	public void endTest(){
		report.endTest(test);
	}
}


