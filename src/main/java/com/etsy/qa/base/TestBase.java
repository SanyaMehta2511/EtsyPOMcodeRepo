package com.etsy.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()  { // build constructor
		
		try {
			prop = new Properties();
			FileInputStream f = new FileInputStream("D:\\QA Sessions\\Selenium_Workspace\\ETSYTest\\src\\main\\java\\config.properties");
			prop.load(f);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
		public static void initialization () { // to launch browser, maximise window, delete cookies, implicit wait time and page load timeout
			String browsername = prop.getProperty("browser"); //launch browser
			if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\QA Sessions\\SeleniumJars\\geckodriver.exe"); 
				
				 driver = new FirefoxDriver(); 
			}
			else if (browsername.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\QA Sessions\\SeleniumJars\\chromedriver.exe");
				 driver = new ChromeDriver(); 
			}
			
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get(prop.getProperty("url"));
			
		
			
			
			
			
		}
	

}
