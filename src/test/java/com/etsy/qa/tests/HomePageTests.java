package com.etsy.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etsy.qa.base.TestBase;
import com.etsy.qa.pages.ClothingPage;
import com.etsy.qa.pages.HomePage;
import com.etsy.qa.pages.JewelleryPage;
import com.etsy.qa.pages.SignInPage;

public class HomePageTests extends TestBase {
	SignInPage signinpage; //global variable
	HomePage homepage;
	ClothingPage clothingpage;
	JewelleryPage jewellerypage;
	
	
	public HomePageTests () {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		signinpage = new SignInPage(); // creating object
		signinpage.ClickOnSignIn();
		homepage = signinpage.SignIn(prop.getProperty("email"), prop.getProperty("password"));
			
	}
	
	
	@Test(priority =1)
	public void verifyTitleTest () {
		String homepageTitle = homepage.verifyTitle();
		Assert.assertEquals(homepageTitle, "Etsy Canada - Shop for handmade, vintage, custom, and unique gifts for everyone", "Home Page Title not Matched");
		
	}
	
	@Test (priority = 2)
	public void ClickOnJewelleryLinkTest () throws InterruptedException {
		Thread.sleep(5000);
		jewellerypage = homepage.ClickOnJewllerylink();
		
	
	}
	
	@Test (priority = 3)
	public void ClickOnClothinglinkTest () throws InterruptedException {
		Thread.sleep(5000);
		clothingpage = homepage.ClickOnClothingLink();
		
	}
	
	@Test (priority = 4)
	public void CValidateLogoTest () {
		homepage.validateLogo();
		Assert.assertTrue(true, "Logo not displayed");
		
	}
	
	@Test (priority = 5)
	public void CValidateUsernameTest () {
	homepage.validateAccountName();
	Assert.assertTrue(true, "Username not found");
		
	}
	
	@AfterMethod 
	public void teardown () {
		driver.quit();
	}
	
 

}
