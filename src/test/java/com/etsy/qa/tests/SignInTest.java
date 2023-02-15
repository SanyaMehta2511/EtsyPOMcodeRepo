package com.etsy.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etsy.qa.base.TestBase;
import com.etsy.qa.pages.HomePage;
import com.etsy.qa.pages.RegistrationPage;
import com.etsy.qa.pages.SignInPage;

public class SignInTest extends TestBase {
	SignInPage signinpage; //global variable
	HomePage homepage;
	RegistrationPage registrationpage;
	
	public SignInTest () {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		signinpage = new SignInPage(); // creating object
			
	}
	
	
	@Test(priority =1)
	public void ClickOnSignInTest () {
		signinpage.ClickOnSignIn();
		
	}
	
	@Test (priority = 2)
	public void SignInTest1 () {
		signinpage.ClickOnSignIn();
		homepage = signinpage.SignIn(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	
	@Test (priority = 3)
	public void ClickOnRegistrationTest () {
		signinpage.ClickOnSignIn();
		registrationpage = signinpage.ClickOnRegister();
	}
	

	
	@AfterMethod 
	public void teardown () {
		driver.quit();
	}
	

}
