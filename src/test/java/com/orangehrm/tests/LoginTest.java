package com.orangehrm.tests;
import org.testng.annotations.Listeners;
import com.orangehrm.utils.TestListener;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import com.orangehrm.utils.ConfigReader;


@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	
	
	@Test(dataProvider = "employeeData")
	public void addEmployeeTest(String firstName, String lastName) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUsername(ConfigReader.getProperty("username"));
	    loginPage.enterPassword(ConfigReader.getProperty("password"));
	    loginPage.clickLoginButton();

	    PIMPage pimPage = new PIMPage(driver);
	    pimPage.clickPIMMenu();
	    pimPage.clickAddEmployee();
	    pimPage.enterFirstName(firstName);
	    pimPage.enterLastName(lastName);
	    
	    String empId = pimPage.getGeneratedEmployeeId();
	    //System.out.println("Captured Employee ID: " + empId);    
		pimPage.clickSaveButton();                               
		pimPage.clickEmployeeList();                              
		pimPage.enterEmployeeId(empId);                          
		pimPage.clickSearchButton(); 
		//Assert.fail("Temporary failure to test screenshot");
	    
	    Assert.assertTrue(pimPage.isEmployeeIdDisplayed(empId));        // here i have failed bcz i wanted to take screenshot
	    //Assert.fail("Testing screenshot on failure"); 

		
	}
	
	@Test
	public void invalidLoginTest() {

	    LoginPage loginPage = new LoginPage(driver);

	    loginPage.enterUsername("InvalidUser");
	    loginPage.enterPassword("InvalidPassword");
	    loginPage.clickLoginButton();
	    
	    Assert.assertTrue(loginPage.isInvalidCredentialsDisplayed());

	}
	
	
	
	@DataProvider(name = "employeeData")
	public Object[][] getEmployeeData() {
	    return new Object[][] {
	        {"Meghana", "G"}
	    };
	}
	
	
		
		
		
	
		
		
		
		

		
		//LoginPage loginPage = new LoginPage(driver);    //Framwork
		/*loginPage.enterUsername("Admin");               //Framwork
		loginPage.enterPassword("admin123");             //Framwork
		loginPage.clickLoginButton();                    //Framwork
		
		//PIMPage pimPage = new PIMPage(driver);            //Framwork
		pimPage.clickPIMMenu();                           //Framwork
		pimPage.clickAddEmployee();                       //Framwork
		pimPage.enterFirstName("Meghana");                //Framwork
		pimPage.enterLastName("G");                            //Framwork
		//String empId = pimPage.getGeneratedEmployeeId();     //Framwork
		System.out.println("Captured Employee ID: " + empId);    //Framwork
		pimPage.clickSaveButton();                               //Framwork
		pimPage.clickEmployeeList();                              //Framwork
		//pimPage.enterEmployeeId("0428");                       //Framwork
		pimPage.enterEmployeeId(empId);                          //Framwork
		pimPage.clickSearchButton();                             //Framwork
		Assert.assertTrue(pimPage.isEmployeeIdDisplayed(empId));  */  //Framwork
		
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		/*WebElement username = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.name("username"))
			);
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();*/
		
		/*wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//a[contains(@href,'viewPimModule')]")
			    )
			).click();*/
			    		
			
		
		/*wait.until(
			    ExpectedConditions.elementToBeClickable(
			       By.linkText("Add Employee")
			    )
			).click();*/
		
		/*wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.name("firstName")
			    )
			).sendKeys("Meghana");
		
		
		
		driver.findElement(By.name("lastName")).sendKeys("G");
		
		wait.until(
			    ExpectedConditions.invisibilityOfElementLocated(
			        By.className("oxd-loading-spinner")
			    )
			);
		
		wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//button[@type='submit']")
			    )
			).click();
		
	
		
		wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.linkText("Employee List")
			    )
			).click();
		
		wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")
			    )
			).sendKeys("0428");
		
		
		wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//button[@type='submit']")
			    )
			).click();*/
		
		
		
		
		//WebElement dashboard = wait.until(
			    //ExpectedConditions.visibilityOfElementLocated(
			       // By.className("oxd-topbar-header-breadcrumb-module")
			   // )
			//);

			//System.out.println(dashboard.isDisplayed());
			
		//wait.until(
			    //ExpectedConditions.elementToBeClickable(
			       // By.xpath("//span[@class='oxd-userdropdown-tab']")
			   // )
			//).click();
			
			//wait.until(
				    //ExpectedConditions.elementToBeClickable(By.linkText("Logout"))
				//).click();
			
			//WebElement loginHeading = wait.until(
				   // ExpectedConditions.visibilityOfElementLocated(
				       // By.xpath("//h5[text()='Login']")
				    //)
				//);

				//System.out.println(loginHeading.isDisplayed());
		
		//driver.quit();
		
		

	}


