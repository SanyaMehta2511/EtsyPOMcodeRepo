package com.etsy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.etsy.qa.base.TestBase;

public class JewelleryPage extends TestBase  {
	
	// Page Factory
	
	@FindBy( id = "logo")
	WebElement logobtn;
	
	@FindBy(xpath = "//div[@class='wt-show-lg wt-hide-xs']")
	WebElement  sortby;
	
	@FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
	WebElement filterby;
	
	@FindBy(xpath = "//label[contains(text(), 'FREE delivery')]")
	WebElement filteroption;
	
	@FindBy(xpath = "//button[@aria-label = 'Apply']")
	WebElement applyoption;
	//Initialization 
	
	public JewelleryPage () {
		PageFactory.initElements(driver, this);
	}
	
	//Actions 
	
	public String verifypagetitle () {
	return	driver.getTitle();
	}
	
	public boolean verifylogo () {
		return logobtn.isDisplayed();
	}
	
	public void sortingby () {
		sortby.click();
	}
	
	public void filteringby () {
		filterby.click();
		filteroption.click();
		applyoption.click();
	}
	

}
