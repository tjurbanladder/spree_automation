package com.urbanladder.com.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.urbanladder.com.PageFactory.LoginPage;
import com.urbanladder.com.PageFactory.BrowserFactory;
import com.urbanladder.com.spree_automation.SafariDriverTests;

public class TestLoginPage extends SuperTestNG{

	//Properties config;
	LoginPage objLogin;
	final Logger LOG = LoggerFactory.getLogger(TestLoginPage.class);
	
	@BeforeMethod
	public void setupTestLoginPageURL() throws IOException
	{
//		config = new Properties();
//		FileInputStream fn = new FileInputStream("/Users/tarunjain/Documents/WorkSpace/spree_automation/src/test/resources/config.properties");
//		config.load(fn);
		LOG.info("CalledBeforeMethod");
		driver.get(config.getProperty("BASE_URL") + "/login");
	}
	
	
	/**
	 * This test go to https://stg1-hercules.urbanladder.com/admin/login
	 * Verify login page title
	 * Login to application
	 * @throws InterruptedException 
	 */
	@Test(priority=1)
	public void test_login_Page_Correct() throws InterruptedException{
		LOG.info("Called test_login_Page_Correct");
		//Create Login Page object
	objLogin = new LoginPage(driver);
	
	//login to application
	objLogin.loginToSpree(config.getProperty("USERNAME"),config.getProperty("PASSWORD"));
	//Thread.sleep(1000);
	LOG.info("Title Assert on Home Page- Started");
	Assert.assertEquals(driver.getTitle(), "Online Furniture Store: Buy Home, Living, Dining Furniture, Home Decor in India - Urban Ladder");
	LOG.info("Title Assert on Home Page- Completed");
	// go the next page
	}
	
	@Test(priority=0)
	public void test_login_Page_InCorrect(){
		LOG.info("Called test_login_Page_InCorrect");
		//Create Login Page object
	objLogin = new LoginPage(driver);
	
	//login to application
	objLogin.loginToSpree(config.getProperty("USERNAME"),config.getProperty("PASSWORD_WR"));
	
	//get the incorrect error message
	LOG.info("Title Assert on Login Page-Started ");
	Assert.assertEquals(objLogin.getincorrectalert(),"The email or password you entered is incorrect. Please try again.");
	LOG.info("Title Assert on Login Page- Completed");
	
	}
	
	@AfterMethod
	public void teardown()
	{
	//driver.close();

	}
	
	
}
