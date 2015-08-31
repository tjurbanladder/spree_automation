package com.urbanladder.com.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class LoginPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(id="spree_user_email")
	@CacheLookup
	private WebElement username;
	
	@FindBy(id="spree_user_password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(id="spree_user_remember_me")
	private WebElement remembermebox;
	
	@FindBy(css=".btn.btn-primary.btn-block")
	private WebElement login;
	
	@FindBy(linkText ="Forgot Password?")
	private WebElement forgotlink;
	
	@FindBy(css =".alert.alert-danger.alert-auto-dissapear")
	private WebElement incorrectalert;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	//Set user name in textbox
	public void setUserName(String strUserName){
		username.sendKeys(strUserName);
		
	}
	
	//Set password in password textbox
	public void setPassword(String strPassword){
	password.sendKeys(strPassword);
	}
	
	//Click on login button
	public void clickLogin(){
			login.click();
	}
	
	public String getincorrectalert()
	{
		return incorrectalert.getText();
	}
	
	
	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void loginToSpree(String UserName,String Password){
		//Fill user name
		this.setUserName(UserName);
		//Fill password
		this.setPassword(Password);
		//Click Login button
		this.clickLogin();	
	}
}
