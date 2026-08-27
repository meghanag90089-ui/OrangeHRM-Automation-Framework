package com.orangehrm.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.orangehrm.base.BaseTest;

public class TestListener extends TestListenerAdapter {

	    @Override
	    public void onTestFailure(ITestResult result) {

	        Object testClass = result.getInstance();
	        BaseTest baseTest = (BaseTest) testClass;

	        ScreenshotUtil.captureScreenshot(
	            baseTest.getDriver(),
	            result.getName()
	        );
	    }
	}


