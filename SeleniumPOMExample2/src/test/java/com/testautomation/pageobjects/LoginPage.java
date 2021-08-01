package com.testautomation.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver ldriver;
	@FindBy(className="login") WebElement signInBtn;
	@FindBy(id="SubmitLogin") WebElement loginBtn;
	@FindBy(xpath="//input[@class='is_required validate account_input form-control' and @name='email']") 
	WebElement email;
	@FindBy(id="passwd") WebElement password;
	
	//adding new comment to check GitHub commit
	
	public LoginPage(WebDriver rdriver) {
		this.ldriver = rdriver;
	}
	
	public String Login( String username, String appPassword) throws InterruptedException {
		
		signInBtn.click();
		Thread.sleep(2000); //wait for login page to load
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(appPassword);
		loginBtn.click();
		
		return ldriver.getTitle();
			
	}
	
}
