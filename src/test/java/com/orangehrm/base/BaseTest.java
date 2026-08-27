package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.utils.ConfigReader;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		String browser = ConfigReader.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
		    driver = new ChromeDriver();
		}
	    driver.manage().window().maximize();
	    driver.get(ConfigReader.getProperty("url"));
	}
	public WebDriver getDriver() {   
        return driver;
	}
	
	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}

}
