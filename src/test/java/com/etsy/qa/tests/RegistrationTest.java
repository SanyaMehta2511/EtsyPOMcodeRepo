package com.etsy.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etsy.qa.base.TestBase;
import com.etsy.qa.pages.RegistrationPage;
import com.etsy.qa.pages.SignInPage;
import com.etsy.qa.util.EtsyUtilities;

public class RegistrationTest extends TestBase {
	
	SignInPage signinpage;
	RegistrationPage registrationpage;
	String sheetname = "SheetName";
	
	public RegistrationTest () {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		signinpage = new SignInPage(); // creating object
		signinpage.ClickOnSignIn();
		Thread.sleep(2000);
		registrationpage = signinpage.ClickOnRegister();
		Thread.sleep(2000);
		
			
	}
	
	/*@Test(priority =1) //page changing thus not able to get the title
	public void verifyTitleTest () {
		String Registrationpagetitle = registrationpage.verifypagetitle();
		Assert.assertEquals(Registrationpagetitle, "Join | Etsy", "Registration Page Title not Matched");
	}*/
	@DataProvider
	public Object[][] gettestdata() {
		Object data [][] = EtsyUtilities.getTestData(sheetname);
		return data;	
	}
	
	@Test(priority =2, dataProvider = "gettestdata")
	public void verifycreatenewregistration (String email, String username, String password) {
		registrationpage.registernewcontact(email, username, password);
			
	}
	
	@AfterMethod 
	public void teardown () {
		driver.quit();
	}
	
	

}
