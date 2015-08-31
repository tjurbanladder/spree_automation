package com.urbanladder.com.spree_automation;

import java.io.IOException;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.urbanladder.com.Utility.XMLtoJsonConverter;
import com.urbanladder.com.tests.SuperTestNG;


public class TestNGExampleTests extends SuperTestNG {
	WebDriver driver;
	String baseURL = "https://www.linkedin.com/";



	

	
	
	
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void verifyLoginPageText() {
		driver.navigate().to(baseURL);
		System.out.println("Verify login page test started");
		WebElement element = driver.findElement(By.cssSelector(".join-form-wrapper.form-wrapper>h2"));
		String headerText = element.getText();
		Assert.assertEquals(headerText, "Get started - it's free.");
	}

	@Test(priority=2)
	public void verifyForgotPasswordPage() {
		driver.navigate().to(baseURL);
		System.out.println("Verify Forgot password page test started");
		WebElement element = driver.findElement(By.linkText("Forgot password?"));
		element.click();
		WebElement pageTextElement = driver.findElement(By.cssSelector(".flow-login-content>fieldset>h1"));
		String pageText = pageTextElement.getText();
		//Assert.assertEquals(pageText, "Wrong text");
		Assert.assertEquals(pageText, "Change your password");
	}
	
	@AfterClass
	public void teardwon()
	{
		driver.close();
	}
}