package com.etsy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.qa.base.TestBase;

public class ClothingPage extends TestBase {
	
	//page factory 
	
	@FindBy( id = "logo")
	WebElement logobtn;
	
	@FindBy(xpath = "//div[@class='wt-show-lg wt-hide-xs']")
	WebElement  sortby;
	
	@FindBy(xpath = "//a[contains(text(),'Highest Price')]")
	WebElement  sortbyoption;
	
	@FindBy(id = "search-filter-button")
	WebElement filterby;
	
	@FindBy(xpath = "//label[contains(text(), 'FREE delivery')]")
	WebElement filteroption;
	
	@FindBy(xpath = "//label[contains(text(),'Under CA$25')]")
	WebElement filteroption2;
	
	@FindBy(xpath = "//button[@aria-label = 'Apply']")
	WebElement applyoption;
	//Initialization 
	
	public ClothingPage () {
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
		sortbyoption.click();
	}
	
	public void filteringby () {
		filterby.click();
		filteroption.click();
		filteroption2.click();
		applyoption.click();
	}
	

}


