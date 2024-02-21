# Appium Mobile Test Automation

This repository contains the test automation framework for the Score app using Appium, Selenium, and Java.

## Prerequisites

Before running the tests, make sure you have the following software installed:

- Java Development Kit (JDK) (version 15)
- Java (JRE) 1.8
- Android SDK (version 34.0.0 RC3)
- Appium (version 2.5.1)
- Node.js and npm (10.4.0)
- Maven (version 4.0.0)

## Maven Dependencies:
Selenium java - 3.141.59
Appium Java Client - 7.6.0
TestNG - 7.9.0
Logging slf4j - 1.7.32, logback -1.2.6


## Running the Tests
To run the tests, follow these steps:

Start the Appium server and Connect your mobile device to your machine or start the Android emulator.
Two ways to execute:
1. Directly run the test class - ScoreAppTest.java
2. Run ScoreAppTest.xml directly


## What the code does
The automation script aims to achieve the following tasks:

1. Open favorite league and validate Leaders tab
2. Get started and select favorite team and validate team stats
3. Verify that the expected page opens correctly and data displayed correctly with test data given using dataprovider.
4. Verify that page navigation works fine for Leaders and Teams back button

Implementing a data-driven approach using testNG dataprovider, the script enhances flexibility and reusability.
