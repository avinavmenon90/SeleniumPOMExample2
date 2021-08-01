package com.testautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.testautomation.pageobjects.LoginPage;
import junit.framework.Assert;

public class LoginTestCRM extends BaseClass{
	
	
	@Test
	public void loginApp() throws InterruptedException, IOException {
		
		//initiating ExtentTest obj logger
		logger = report.createTest("Logging into AutomationPractice.com"); //specify the test name that appears on the report output
		
		//Initialize LoginPage class using PageFactory:
		/*call the LoginPage constructor & passes driver obj //checks all the
		 * locators are valid on the LoginPage class //returns the LoginPage object 
		 * so it needs to be captured
		 */
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		String username = excelData.getStringData("Login", 1, 0);
		//System.out.println(username);
		String password = excelData.getStringData("Login", 1, 1);
		//System.out.println(password);
		
		String lpTitle = lp.Login(username, password); //Abstraction example (hiding details of how the login takes place)
		
		try {
		Assert.assertEquals("My account - My Store", lpTitle); //assert Account Page Title
		logger.pass("The test PASSED!");
		}catch(AssertionError e) {
			logger.fail("The test failed!");
		}
		
		Thread.sleep(1000);
		
	}
	

	
}
