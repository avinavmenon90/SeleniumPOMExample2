package com.testautomation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	
	public static WebDriver startApplication(String browser, String appURL, WebDriver driver) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./src/test/java/com/testautomation/utilities/Browser WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","./src/test/java/com/testautomation/utilities/Browser WebDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			
			System.setProperty("webdriver.edge.driver","./src/test/java/com/testautomation/utilities/Browser WebDrivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Sorry, we don't support this browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	public static void closeBrowser(WebDriver driver) {
		
		driver.close();
		driver.quit();
	}
}
