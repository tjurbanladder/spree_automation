package com.urbanladder.com.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.urbanladder.com.PageFactory.BrowserFactory;
import com.urbanladder.com.Utility.XMLtoJsonConverter;

public class SuperTestNG {
	
	Properties config;
	WebDriver driver;
	InputStream inputStream;
	final Logger LOG = LoggerFactory.getLogger(SuperTestNG.class);
	
	@BeforeSuite
	public void beforesuite()  throws IOException, InterruptedException{
	
		}
		
	@BeforeTest
	public void setup() throws IOException{

		LOG.info("CalledBeforeTest");
		try{
			config = new Properties();
			FileInputStream fn = new FileInputStream("/Users/tarunjain/Documents/WorkSpace/spree_automation/src/test/resources/config.properties");
			config.load(fn);
			driver = BrowserFactory.getBrowser(config.getProperty("BROWSER"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//driver.get(Config.getProperty("BASE_URL") + "/login");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		LOG.info("ExitingBeforeTest");
	}
	
	@AfterTest
	public void teardown_super()
	{
		//BrowserFactory.closeAllDriver(); [Talk to Rahul]
	}
	
	@AfterSuite
	public void aftersuite()
	{
		LOG.info("CalledAfterSuite");
		BrowserFactory.closeAllDriver();
		String str = null;
		try 
		{
			 str = XMLtoJsonConverter.readFile("/Users/tarunjain/Documents/WorkSpace/spree_automation/test-output/testng-results.xml");
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		JSONObject jsobj = XMLtoJsonConverter.toJSONObject(str);
		LOG.info("===================================");
		LOG.info(jsobj.toString());
		LOG.info("===================================");
	}
    
}