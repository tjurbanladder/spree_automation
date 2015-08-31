package com.urbanladder.com.spree_automation;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.urbanladder.com.Utility.ScreenshotCapture;

public class SafariDriverTests
{

	  private WebDriver driver = null;
	  
	  
	  
	  final static Logger LOG = LoggerFactory.getLogger(SafariDriverTests.class);
	  private static boolean isSupportedPlatform() {
	    Platform current = Platform.getCurrent();
	    return Platform.MAC.is(current) || Platform.WINDOWS.is(current);
	    
	    
	  }
	  @BeforeTest
	  public void createDriver() throws IOException, InterruptedException {
	    AssertJUnit.assertTrue(isSupportedPlatform());
	   //System.setProperty("webdriver.chrome.driver", "/Users/tarunjain/Documents/WorkSpace/spree_automation/drivers/chromedriver");
	   //driver = new ChromeDriver(DesiredCapabilities.chrome());
	    driver = new SafariDriver();

	  }

	  @AfterTest
	  public void quitDriver() {
	    driver.quit();

	  }

	  @Test
	  public void shouldBeAbleToPerformAGoogleSearch() {
	    driver.get("http://www.google.com");
	    driver.findElement(By.name("q")).sendKeys("webdriver");
	    driver.findElement(By.name("btnG")).click();
	    new WebDriverWait(driver, 10)
	        .until(ExpectedConditions.titleIs("webdriver - Google Search"));
	    String title = driver.getTitle();
	    Assert.assertEquals(title, "webdriver - Google Search");
	   // ScreenshotCapture.takescreenshot("First");
	    
	   
	    
	    
	  }
	}
