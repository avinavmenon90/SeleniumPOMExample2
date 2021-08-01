package com.testautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {

	//class used to:
		/*
		 * Capture Screenshots
		 * Handle Alerts & Frames
		 * Handle Windows Sync Issues
		 * Use JavaScriptExecutor
		 * Get Current Time
		 */
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\src\\test\\java\\com\\testautomation\\utilities\\Screenshots\\"+getCurrentDateAndTime()+".png";
		
		try {
			FileHandler.copy(src, new File(destFile));
			System.out.println("screenshot captured");
			System.out.println("Destination file path: "+destFile);			
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot:  "+e.getMessage());
			e.printStackTrace();
		}
		
		return destFile;
	}
	
	public static String getCurrentDateAndTime() { //get current Date and Time in specified format
		
		DateFormat customFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
		
	}
}
