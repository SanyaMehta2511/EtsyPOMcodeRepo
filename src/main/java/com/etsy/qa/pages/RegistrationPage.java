package com.etsy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.qa.base.TestBase;

public class RegistrationPage extends TestBase {
	
	//Object repository : Page Factory
	
	
	@FindBy(xpath = "//button[@class = 'wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")
	WebElement signin;

	@FindBy(name = "email")
	WebElement remail;
	
	@FindBy(name = "first_name")
	WebElement fname;

	@FindBy (name = "password")
	WebElement rpassword;

	@FindBy (name = "submit_attempt")
	WebElement register;
	
	public RegistrationPage () { //to initialize the OR
		
		PageFactory.initElements(driver, this);	
		
	}
	
	//Actions 
	
	public String verifypagetitle () {
		return	driver.getTitle();
		}
	
	public void registernewcontact (String email, String FTname, String password) {
		remail.sendKeys(email);
		fname.sendKeys(FTname);
		rpassword.sendKeys(password);
		register.click();
	}
	
	


}
