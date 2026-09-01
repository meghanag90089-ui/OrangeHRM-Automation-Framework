package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotUtil {
	
	public static void captureScreenshot(WebDriver driver, String testName) {

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    
	    //File screenshotDir = new File("screenshots");
	    File screenshotDir = new File("target/screenshots");

	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs();
	    }

	    /*File destination = new File(
	        "screenshots/" + testName + ".png"
	    );*/
	    File destination = new File(
	    	    "target/screenshots/" + testName + ".png"
	    	);

	    try {
	    	Files.copy(
	    		    source.toPath(),
	    		    destination.toPath(),
	    		    StandardCopyOption.REPLACE_EXISTING
	    		);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
