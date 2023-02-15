package com.etsy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.etsy.qa.base.TestBase;

public class SignInPage extends TestBase  {
	
	//Object repository : Page Factory
	
	
@FindBy(xpath = "//button[@class = 'wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")
WebElement signin;

@FindBy(name = "email")
WebElement email;

@FindBy (name = "password")
WebElement password;

@FindBy (name = "submit_attempt")
WebElement submit;

@FindBy (xpath = "//button[@class = 'wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")
WebElement register;

public SignInPage () { //to initialize the OR
	PageFactory.initElements(driver, this);
	
}
//Actions

  public void ClickOnSignIn () {
	  signin.click();
	  
  }
  
  public HomePage SignIn (String em, String pwd) {
	  email.sendKeys(em);
	  password.sendKeys(pwd);
	  submit.click();
	  
	  return new HomePage();
	  
  }
  
  public RegistrationPage ClickOnRegister () {
	  register.click();
	  
	  return new RegistrationPage ();
	  
  }
  
  
}
