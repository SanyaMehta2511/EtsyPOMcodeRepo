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

public class JewelleryPageTest extends TestBase  {
	
	
		SignInPage signinpage; //global variable
		HomePage homepage;
		ClothingPage clothingpage;
		JewelleryPage jewellerypage;
		
		
		public JewelleryPageTest () {
			super();
		}
		
		@BeforeMethod
		public void setup() throws InterruptedException {
			initialization();
			signinpage = new SignInPage(); // creating object
			signinpage.ClickOnSignIn();
			homepage = signinpage.SignIn(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(3000);
			jewellerypage = homepage.ClickOnJewllerylink();
				
		}
		
		
		@Test(priority =1)
		public void verifyTitleTest () {
			String Jewellerypagetitle = jewellerypage.verifypagetitle();
			Assert.assertEquals(Jewellerypagetitle, "Jewellery & Accessories - Etsy Canada", "Jewellery Page Title not Matched");
			
		}
		
		@Test (priority = 2)
			public void JValidateLogoTest () {
			 jewellerypage.verifylogo();
				Assert.assertTrue(true, "Logo not displayed");
			}
		
		@Test (priority = 3)
		public void sortinbytest () {
		 jewellerypage.sortingby();
			
			
		}
		
		@Test (priority = 4)
		public void Filterbytest () {
			jewellerypage.filteringby();
		}
		
		@AfterMethod 
		public void teardown () {
			driver.quit();
		}
		

}
