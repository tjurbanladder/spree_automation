package com.urbanladder.com.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
	
	WebDriver driver;
	int avai_quan = 0;

	//New Order Button
	@FindBy(id="admin_new_order")
	private WebElement new_order;
	
	// > Button
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div[1]/span/button")
	@CacheLookup
	private WebElement filter_dropdwon;
	
	//Direct Search
	@FindBy(id="quick_search")
	private WebElement quicksearch_order;
	
	// Order number textbox
	@FindBy(id="q_number_cont")
	private WebElement order_search;
	
	// Filter Results Button
	@FindBy(xpath="//*[@id=\"spree/order_search\"]/div[5]/button")
	private WebElement filter_order_button;
	
	
	// Variant search drop down to enter text for search
	@FindBy(css="#s2id_add_line_item_variant_id > a")
	private WebElement variant_search_drop;
	
	//Text box to enter the variant name
	@FindBy(id="s2id_autogen3_search")
	private WebElement variant_search_text;
	
	//
	@FindBy(id="s2id_add_line_item_variant_id")
	private WebElement select_dropdown;
	
	// Select an item from the available option.
	@FindBy(xpath="//*[@id='select2-results-3']/li[2]")
	private WebElement select_variant;

	// Overall (Default) Quantity Dropdown (For MTO)
	@FindBy(id="stock_item_quantity")
	private WebElement overall_quantity_mto;
	
	// Overall (Default) Quantity Dropdown (For MTS)
		@FindBy(id="variant_quantity")
		private WebElement overall_quantity_mts;
	
	
	// + Button
	@FindBy(xpath="//*[@id=\"stock_details\"]/table/tbody/tr[1]/td[4]/button")
	private WebElement add_quantity;
	
	
	//*[@id="select2-result-label-262"]/div/div
	//*[@id='select2-result-label-187']/div/div
	

	
	public OrderPage(WebDriver driver)
	{
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	public void expandseacrh()
	{
		filter_dropdwon.click();
	}
	
	public void setsearchorder(String Order_no)
	{
		order_search.sendKeys(Order_no);
	}

	public void click_filter_search()
	{
		filter_order_button.click();
	}
	
	public String get_search_order_text(String Order_no)
	{
		return driver.findElement(By.linkText(Order_no)).getText();
			
	}
	
	public void click_new_order()
	{
		new_order.click();
	}
	
	public void search_variant_drop()
	{
		variant_search_drop.click();
	}
	
	public void search_variant(String variant_name)
	{
		variant_search_text.sendKeys(variant_name);
		
	}
	
	public void select_variant() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		select_variant.click();
	}
	
	public int check_existng_quantity()
	{
		avai_quan = Integer.parseInt(overall_quantity_mts.getAttribute("value"));
		
		return avai_quan;
	}
	
	public void add_quantity()
		{
			add_quantity.click();	
		}
		
		
	}
	
	

