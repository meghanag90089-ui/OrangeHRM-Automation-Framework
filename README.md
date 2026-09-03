# OrangeHRM Automation Framework

## Overview
Selenium automation framework for testing the OrangeHRM application using Java, TestNG, Maven, and Page Object Model.

## Technologies
- Java 17
- Selenium WebDriver
- TestNG
- Maven
- ExtentReports
- Git & GitHub
- Jenkins

## Framework Structure

src/test/java
├── com.orangehrm.base
│   └── BaseTest.java
├── com.orangehrm.page
│   ├── LoginPage.java
│   └── PIMPage.java
├── com.orangehrm.test
│   └── LoginTest.java
└── com.orangehrm.utils
    ├── ConfigReader.java
    ├── ScreenshotUtil.java
    └── TestListener.java

## Features
- Page Object Model
- Explicit waits
- TestNG DataProvider
- Cross-browser execution
- Parallel execution
- ExtentReports
- Failure screenshots
- Maven test execution
- Jenkins CI integration
- GitHub source control

## Test Execution

Run the TestNG suite:

```bash
mvn clean test