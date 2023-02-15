package com.etsy.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.qa.base.TestBase;

public class HomePage extends TestBase  {
	
	// Page Factory 
	
	@FindBy(xpath = "//button[@data-selector = 'you-menu-tooltip']")
	WebElement accountbtn;
	
	@FindBy(xpath = "//h4[contains(text(),'sandym')]")
	WebElement username;
	
	@FindBy(xpath = "//span[@class = 'etsy-icon wt-display-block wt-fill-orange wt-nudge-r-3 wt-nudge-t-1 logo-dimensions']")
	WebElement logo;
	
	@FindBy(xpath = "//span[contains(text(),'Jewellery & Accessories')]")
	WebElement jewellerylink;
	
	@FindBy(xpath = "//span[contains(text(),'Clothing & Shoes')]")
	WebElement clothinglink;
	
	
	//Initialization 
	
	public HomePage () { 
		PageFactory.initElements(driver, this);
	}
	//Action
		
	public String verifyTitle () {
		return driver.getTitle();
	}
	
	public JewelleryPage ClickOnJewllerylink() {
		
		jewellerylink.click();
		
		return new JewelleryPage();
	}
	
	public ClothingPage ClickOnClothingLink() {
		
		clothinglink.click();
		
		return new ClothingPage();
	}
	
	public boolean validateLogo () {
		return logo.isDisplayed();
	}
	
	
	public boolean validateAccountName() {
		accountbtn.click();
		return username.isDisplayed();
		
		
	}
	
	
	
	
	

}
