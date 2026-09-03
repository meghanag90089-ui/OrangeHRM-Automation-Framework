package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By pimMenu = By.xpath("//a[contains(@href,'viewPimModule')]");
	private By addEmployee = By.linkText("Add Employee");
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By loadingSpinner = By.className("oxd-loading-spinner");
	private By saveButton = By.xpath("//button[@type='submit']");
	
	private By employeeList = By.linkText("Employee List");
	private By employeeId = By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
	private By searchButton = By.xpath("//button[@type='submit']");
	
	private By generatedEmployeeId = By.xpath(
		    "//label[text()='Employee Id']/parent::div/following-sibling::div/input"
		);
	
	public PIMPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void clickPIMMenu() {
		wait.until(
				ExpectedConditions.elementToBeClickable(pimMenu)
				).click();
	}
	public void clickAddEmployee() {
		wait.until(
				ExpectedConditions.elementToBeClickable(addEmployee)
				).click();
	}
	public void enterFirstName(String fName) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(firstName)
				).sendKeys(fName);
		}
	public void enterLastName(String lName) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(lastName)
				).sendKeys(lName);
	}
	public void clickSaveButton() {
		wait.until(
		        ExpectedConditions.invisibilityOfElementLocated(loadingSpinner)  //Loading spinner disappears → Save button becomes clickable → Click Save
		    );
		
		wait.until(
				ExpectedConditions.elementToBeClickable(saveButton)
				).click();
		 // Wait until employee creation is completed
	    wait.until(
	        ExpectedConditions.urlContains("viewPersonalDetails")
	    );
	}
	public void clickEmployeeList() {
	    wait.until(
	        ExpectedConditions.elementToBeClickable(employeeList)
	    ).click();
	}
	public void enterEmployeeId(String empId) {
	    wait.until(
	        ExpectedConditions.visibilityOfElementLocated(employeeId)
	    ).sendKeys(empId);
	}
	public void clickSearchButton() {
	    wait.until(
	        ExpectedConditions.elementToBeClickable(searchButton)
	    ).click();
	}
	
	public String getGeneratedEmployeeId() {

	    WebElement employeeIdField = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(generatedEmployeeId)
	    );

	    wait.until(driver ->
	        !employeeIdField.getAttribute("value").isEmpty()
	    );

	    return employeeIdField.getAttribute("value");
	}
	
	public boolean isEmployeeIdDisplayed(String empId) {

	    By resultEmployeeId = By.xpath(
	        "//div[@role='row']//div[text()='" + empId + "']"
	    );

	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(resultEmployeeId)
	    ).isDisplayed();
	}

}


//Testing Jenkins Poll SCM
