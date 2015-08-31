package com.urbanladder.com.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.urbanladder.com.PageFactory.BrowserFactory;
import com.urbanladder.com.PageFactory.LoginPage;
import com.urbanladder.com.PageFactory.OrderPage;

public class TestOrderPage extends SuperTestNG {
	
	//Properties config;
	LoginPage objLogin;
	OrderPage objOrder;
	final Logger LOG = LoggerFactory.getLogger(TestOrderPage.class);
	
	@BeforeMethod
	public void setTestOrderPageURL() throws IOException
	{
//		config = new Properties();
//		FileInputStream fn = new FileInputStream("/Users/tarunjain/Documents/WorkSpace/spree_automation/src/test/resources/config.properties");
//		config.load(fn);
		LOG.info("CalledBeforeMethod");
	//	driver.get(config.getProperty("BASE_URL")+ "/login");
	
	}
	
	@Test(priority=0)
	public void test_order_search() throws InterruptedException
	{
		LOG.info("Called test_order_search");
		//Create Order Page object
		//objLogin = new LoginPage(driver);
		objOrder = new OrderPage(driver);
		//objLogin.loginToSpree(config.getProperty("USERNAME"),config.getProperty("PASSWORD"));
		//Thread.sleep(1000);
		driver.get(config.getProperty("BASE_URL") + "/orders");
		objOrder.expandseacrh();
		//Thread.sleep(100);
		objOrder.setsearchorder(config.getProperty("ORDER_SEARCH"));
		objOrder.click_filter_search();
		String order = objOrder.get_search_order_text(config.getProperty("ORDER_SEARCH"));
		LOG.info("Order Check Assert on Order Page- Started");
		Assert.assertEquals(order,config.getProperty("ORDER_SEARCH"));
		LOG.info("Order Check Assert on Order Page- Completed");
	
		
	}
	
	@Test(priority=1)
	public void new_order() throws InterruptedException
	{
		LOG.info("Called new_order");
		objOrder = new OrderPage(driver);
		objOrder.click_new_order();
		objOrder.search_variant_drop();
		objOrder.search_variant(config.getProperty("VARIANT_SEARCH_NEW_ORDER"));
		//Thread.sleep(5000);
		objOrder.select_variant();
		//Thread.sleep(3000);
		if (objOrder.check_existng_quantity() >0)
		{
			objOrder.add_quantity();
			//Thread.sleep(3000);
		}
		else
		{
			LOG.error("Quantity Unavailable");
			
		}
		
	}

}
