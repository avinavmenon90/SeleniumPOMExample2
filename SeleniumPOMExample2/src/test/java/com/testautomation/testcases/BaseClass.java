package com.testautomation.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.testautomation.utilities.BrowserFactory;
import com.testautomation.utilities.ExcelDataProvider;
import com.testautomation.utilities.HelperClass;
import com.testautomation.utilities.ReadPropertyFile;

public class BaseClass {

	WebDriver driver;
	ExcelDataProvider excelData;
	ReadPropertyFile readPropertyFile;
	String browser;
	String url;
	public ExtentReports report;
	public ExtentSparkReporter extent;
	public ExtentTest logger;
	
	@BeforeSuite //load Excel file & Properties file objects before the entire test suite; set up Extent Report
	  public void setUpSuite() {
		
	//generate logs in extent report, and setting to 'true' shows in the Console log
		Reporter.log("Setting up reports and Test is getting ready",true); 
		
		excelData = new ExcelDataProvider();
		readPropertyFile = new ReadPropertyFile();
		
	//Setting up & Initiating Extent Report
		extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/AutomationPractice_"+HelperClass.getCurrentDateAndTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting up is Done - Test can be started",true); 
		
	  }
	
	@BeforeClass 
	  public void setUp() throws InterruptedException {
		
	  Reporter.log("Setting up the browser and opening the URL",true); 	
	
	  browser = readPropertyFile.getProperty("browser");
	  url = readPropertyFile.getProperty("qaURL");
	  
	  //call method to start the appln 
      driver =	BrowserFactory.startApplication(browser, url, driver);
	  Thread.sleep(1000); //need to add 'throws' declaration at  method level to catch InterruptedException 
	  
	  Reporter.log("Browser & app is up and running",true);
	  
	  }
	 
	
	 @AfterClass //close browser after every class
	  public void tearDown() {
	  
		  Reporter.log("Closing the browser and quitting the session",true);
		  BrowserFactory.closeBrowser(driver); 
	  }
	  
	 @AfterMethod //capture screenshot after Pass/Fail of each method
	 public void tearDownMethod(ITestResult result) throws InterruptedException {
		 
		 Reporter.log("Test is about to end",true);
		 
		 //take screenshot on failure of TC
		 if(! result.isSuccess()) {
		 	 //HelperClass.captureScreenshot(driver); //capture screenshot (normally)
		 	 Thread.sleep(2000);
		 //capture screenshot on failure, and add screenshot to the extent report object logger
		 	 logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath( HelperClass.captureScreenshot(driver)).build());
		 }
		 else if(result.isSuccess()) {
			 
			 Thread.sleep(2000);
		//capture screenshot on Pass, and add screenshot to the extent report object logger
		 	 logger.pass("Test PASSED", MediaEntityBuilder.createScreenCaptureFromPath( HelperClass.captureScreenshot(driver)).build());
		 }
		 else if(result.getStatus() == ITestResult.SKIP) {
			 
			 Thread.sleep(2000);
		//capture screenshot on Skip, and add screenshot to the extent report object logger
		 	 logger.skip("Test was Skipped", MediaEntityBuilder.createScreenCaptureFromPath( HelperClass.captureScreenshot(driver)).build());	 
			 
		 }
		 
		 report.flush(); //generate report and add info into report after each Test method
		 
		 Reporter.log("Tests Complete & Reports completed",true);
	 }
	 
	
}
