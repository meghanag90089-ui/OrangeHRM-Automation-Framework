package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.orangehrm.utils.ConfigReader;

public class BaseTest {
	
	protected WebDriver driver;
	
	//@BeforeMethod
	/*public void setUp() {
		
		String browser = ConfigReader.getProperty("browser");
		
		/*if (browser.equalsIgnoreCase("chrome")) {
		    driver = new ChromeDriver();
		}*/
		/*if (browser.equalsIgnoreCase("chrome")) {
		    driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
		    driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
		    driver = new EdgeDriver();
		} else {
		    throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
	    driver.manage().window().maximize();
	    driver.get(ConfigReader.getProperty("url"));
	}*/
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {

	    if (browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    } else if (browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    } else if (browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver();
	    } else {
	        throw new IllegalArgumentException("Unsupported browser: " + browser);
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
