package com.urbanladder.com.spree_automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.urbanladder.com.PageFactory.BrowserFactory;

public class Test1 {
	BrowserFactory Bfact;
	WebDriver driver;
	
	
	@Test
	public void browsertest() throws InterruptedException
	{
		driver = BrowserFactory.getBrowser("Firefox");
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.close();
	}
	
	

}
