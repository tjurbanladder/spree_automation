package com.urbanladder.com.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.urbanladder.com.tests.SuperTestNG;

public class BrowserFactory {
	
	
	private static boolean isSupportedPlatform(String OS) {
	    Platform current = Platform.getCurrent();
	    if (OS == "MAC")
	    return Platform.MAC.is(current);
	    else
	    return	Platform.WINDOWS.is(current);
	}
	
	
	//public static Platform current = Platform.getCurrent();
	
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		case "IE":
			if(isSupportedPlatform("WINDOWS"))
			{
			driver = drivers.get("IE");
			if (driver == null) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				drivers.put("IE", driver);
			}
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				if(isSupportedPlatform("MAC"))
				{
					System.setProperty("webdriver.chrome.driver", "/Users/tarunjain/Documents/WorkSpace/spree_automation/drivers/chromedriver");
					
				}
				else
				{
					System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\abc\\Desktop\\Server\\ChromeDriver.exe");
				}
				 driver = new ChromeDriver(DesiredCapabilities.chrome());
				drivers.put("Chrome", driver);
			}
			break;
		case "Safari" :
			if(isSupportedPlatform("MAC"))
			{
			driver = drivers.get("Safari");
			if (driver == null) {
				driver = new SafariDriver();
				drivers.put("Safari", driver);
			}
			}
			
		}
		return driver;
	}

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
	
	
}