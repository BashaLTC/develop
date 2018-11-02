package wrappers;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers{

	public String browserName;
	
	@BeforeMethod
	public void beforeMethod(){
		startTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
		invokeApp(browserName);
	}
	@AfterMethod
	public void closeBrowsers(){
		closeAllBrowsersNoSnap();
	}
	@BeforeSuite
	public void beforeSuite(){
		startReport();
	}
	@AfterSuite
		public void afterSuite(){
		endReport();
	}
	@AfterClass
		public void afterClass(){
		endTest();
	}
	@BeforeTest
		public void beforeTest(){
		loadObjects();
		
	}
	@AfterTest
		public void afterTest(){
		unloadObjects();
	}
	
}

