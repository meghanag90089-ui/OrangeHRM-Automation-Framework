package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	private By username=By.name("username");
	private By password = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");
	
	private By invalidCredentialsMessage =
	        By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;	
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	public void enterUsername(String userName) {
	    //driver.findElement(username).sendKeys(userName);
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(username)
		    ).sendKeys(userName);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickLoginButton() {
	    driver.findElement(loginButton).click();
	}
	
	public boolean isInvalidCredentialsDisplayed() {
	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(invalidCredentialsMessage)
	    ).isDisplayed();
	}
	

	
	}


