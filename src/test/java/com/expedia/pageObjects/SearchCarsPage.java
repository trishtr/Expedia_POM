package com.expedia.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchCarsPage {

	WebDriver ldriver;
	
	public SearchCarsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//ul[@role='tablist']//li[3]")
	WebElement carbtn;
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Pick-up']")
	WebElement pickupbtn;
	@FindBy(how= How.XPATH, using ="//input[@placeholder='Where are you picking up your car?']")
	WebElement pickupplace;
	@FindBy(how = How.XPATH, using="//button[@aria-label ='Same as pick-up']")
	WebElement dropoffbtn;
	@FindBy(how= How.XPATH, using = "//button[@id='d1-btn']")
	WebElement pickupdate;
	@FindBy(how= How.XPATH, using = "//button[@id='d2-btn']")
	WebElement dropoffdate;
	@FindBy(how = How.XPATH, using = "//select[@aria-label= 'Pick-up time']")
	WebElement pickuptime;
	@FindBy(how = How.XPATH, using = "//select[@aria-label= 'Drop-off time']")
	WebElement dropofftime;
	@FindBy(how=How.XPATH, using = "//summary//span[2]")
	WebElement discountbtn;
	@FindBy(how = How.XPATH, using = "//select[@aria-label ='Preferred brand']")
	WebElement preferredbrand;
	@FindBy(how= How.XPATH, using = "//select[@aria-label='Discount type']")
	WebElement discountselect;
	@FindBy(how= How.XPATH, using = "//button[contains(text(), 'Search')]")
	WebElement searchbtn;
	@FindBy(how=How.XPATH, using = "//div[@class='uitk-date-picker-menu-months-container']//h2[1]")
	WebElement header_element;
	@FindBy(how=How.XPATH, using = "//table[@class='uitk-date-picker-weeks']/tbody/tr/td/button")
	List<WebElement> lstday;
	@FindBy(how=How.XPATH, using = "//div[@class='uitk-calendar']/descendant::button[2]")
	WebElement forwardbtn;
	@FindBy(how=How.XPATH, using = "//div[@class='uitk-flex uitk-date-picker-menu-footer']/button")
	WebElement donebtn;
	
	public void clickcarbtn() {
		carbtn.click();
	}
	
	public void clickpickupbtn() {
		pickupbtn.click();
	}
	public void selectpickupplace(String pickupname) {
		pickupplace.sendKeys(pickupname);
		pickupplace.sendKeys(Keys.ENTER);

    }
	public void clickpickupdate() {
		pickupdate.click();
	}
	public void clickdropoffdate() {
		dropoffdate.click();
	}
	public void clickdropoffbtn() {
		dropoffbtn.click();
	}
	public String getheaderText() {
		String header = header_element.getText();
		return header;
	}
	public void selectpickupdate(String selectpickupdate) {
		while(true)
		{
			String header = getheaderText();
			if(header.equals(selectpickupdate))
			{
				break;
			}
			else
			{
				forwardbtn.click();
			}
			
		}
	}
	public void selectpickupday(String selectpickupday) {
		for(WebElement day: lstday)
		{
			if(day.equals(selectpickupday))
			{
				day.click();
				break;				
			}
		}
	}
	
	public void selectdropoffdate(String selectdropoffdate) {
		while(true)
		{
			String header = getheaderText();
			if(header.equals(selectdropoffdate))
			{
				break;
			}
			else
			{
				forwardbtn.click();
			}
			
		}
	}
	public void selectdropoffday(String selectdropoffday) {
		for(WebElement day: lstday)
		{
			if(day.equals(selectdropoffday))
			{
				day.click();
				break;				
			}
		}
	}
	public void clickdonebtn() {
		donebtn.click();
	}
	public void selectPickupTime(String selectpickuptime) 
	{
		
		Select select = new Select(pickuptime);
		select.selectByVisibleText(selectpickuptime);
	}
	public void selectDropoffTime(String selectdropofftime) 
	{
		Select select = new Select(dropofftime);
		select.selectByVisibleText(selectdropofftime);
	}
	public void clickDiscountBtn() {
		discountbtn.click();
	}
	public void selectPreferredBrand(String selectbrand)
	{
		Select select = new Select(preferredbrand);
		select.selectByVisibleText(selectbrand);
	}
	public void selectDiscountType(String discounttype)
	{
		Select select = new Select(discountselect);
		select.selectByVisibleText(discounttype);
	}
	public void clickSearchBtn() {
		searchbtn.click();
	}
}
