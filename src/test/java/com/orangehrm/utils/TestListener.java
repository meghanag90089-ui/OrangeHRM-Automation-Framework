package com.orangehrm.utils;

/*import org.testng.ITestResult;
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
	}*/
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangehrm.base.BaseTest;

public class TestListener extends TestListenerAdapter {

    static ExtentReports extent;
    static ExtentTest test;

    static {
        ExtentSparkReporter spark =
                new ExtentSparkReporter("target/ExtentReports/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        Object testClass = result.getInstance();
        BaseTest baseTest = (BaseTest) testClass;

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        baseTest.getDriver(),
                        result.getName()
                );

        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();
    }
}


