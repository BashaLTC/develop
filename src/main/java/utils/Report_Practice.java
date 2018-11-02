package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Report_Practice {
	
	public static ExtentReports reporter;
	public ExtentTest test;
	
	public void reportStep(String desc, String status){
		
		
		long snapnumber = 10000000l;
		
		snapnumber = takesnap();
		
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.addScreenCapture("./screenshots"+snapnumber+".jpeg"));
		}else if (status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("./screenshots"+snapnumber+".jpeg"));
		}else if (status.toUpperCase().equals("WARN")){
			test.log(LogStatus.WARNING, desc+test.addScreenCapture("./screenshots"+snapnumber+".jpeg"));
		}else if (status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
		
		
	}

public abstract long takesnap();

	public void reportStep(String desc, String status, boolean snap){
		
		if(snap==false){
			if(status.equalsIgnoreCase("pass")){
			test.log(LogStatus.PASS, desc);
			}
		}
	}
	
	public ExtentReports startReport(){
		reporter = new ExtentReports("./reports/report.html");
		return reporter;
		
	}
	public ExtentTest startTest(String testcasename, String testcaseDescription){
		test = reporter.startTest(testcasename, testcaseDescription);
		return test;
	}

}
