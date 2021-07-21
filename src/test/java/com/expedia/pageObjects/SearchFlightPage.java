package com.expedia.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchFlightPage {

	WebDriver ldriver;
	
	public SearchFlightPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//ul[@role='tablist']//li[2]")
	WebElement flightbtn;
	@FindBy(how=How.XPATH, using = "//button[@aria-label='Leaving from']")
	WebElement leavingbtn;
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Where are you leaving from?']")
	WebElement leavingtxt;
	@FindBy(how=How.XPATH, using = "//button[@aria-label='Going to']")
	WebElement goingbtn;
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Where are you going to?']")
	WebElement goingtxt;
	@FindBy(how=How.XPATH, using = "//button[@id='d1-btn']")
	WebElement departbtn;
	@FindBy(how=How.XPATH, using = "//button[@id='d2-btn']")
	WebElement returnbtn;
	@FindBy(how=How.XPATH, using = "//select[@aria-label= 'Pick-up time']")
	WebElement pickuptime;
	@FindBy(how=How.XPATH, using = "//select[@aria-label = 'Drop-off time']")
	WebElement droppfftime;
	@FindBy(how=How.XPATH, using = "//summary//span[2]")
	WebElement discountbtn;
	@FindBy(how=How.XPATH, using = "//select[@aria-label ='Preferred brand']")
	WebElement perferredbrand;
	@FindBy(how=How.XPATH, using = "//select[@aria-label='Discount type']")
	WebElement discountselect;
	@FindBy(how=How.XPATH, using = "//div[@class='uitk-date-picker-menu-months-container']//h2[1]")
	WebElement header_element;
	@FindBy(how=How.XPATH, using = "//table[@class='uitk-date-picker-weeks']/tbody/tr/td/button")
	List<WebElement> lstday;
	@FindBy(how=How.XPATH, using = "//div[@class='uitk-calendar']/descendant::button[2]")
	WebElement forwardbtn;
	@FindBy(how=How.XPATH, using = "//div[@class='uitk-flex uitk-date-picker-menu-footer']/button")
	WebElement donebtn;
	@FindBy(how=How.XPATH, using = "//button[contains(text(),'Search')]")
	WebElement searchbtn;
	@FindBy(how= How.XPATH, using = "//ul[@data-test-id='listings']")
	WebElement listflight;
	@FindBy(how=How.XPATH, using = "//ul[@role='tablist']//li[2]")
	WebElement returningflighttab;
	@FindBy(how =How.XPATH, using = "//li[@aria-label='Step 1 of 3. Choose departing flight. Current page']//div")
	WebElement result;
	@FindBy(how = How.XPATH, using = "//ul[@role='list']//li[1]//button[1]")
	WebElement firstresult;
	@FindBy(how= How.XPATH, using = "//ul[@class='uitk-carousel-item-container']//li[1]//button")
	WebElement firstflight;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'No Thanks')]")
	WebElement nobtn;
	
	public void clickFlightBtn() {
		flightbtn.click();
	}
	public void clickLeavingBtn() {
		leavingbtn.click();
	}
	public void setLeavingPlace(String leavingcity) {
		leavingtxt.sendKeys(leavingcity);
		leavingtxt.sendKeys(Keys.ENTER);
	}
	public void clickGoingBtn() {
		goingbtn.click();
	}
	public void setGoingPlace(String goingcity) {
		goingtxt.sendKeys(goingcity);
		goingtxt.sendKeys(Keys.ENTER);
	}
	public void clickdepartbtn() {
		departbtn.click();
	}
	public void clickreturnbtn() {
		returnbtn.click();
	}
	public void clicksearchbtn() {
		searchbtn.click();
	}
	
	public String getTextheader() {
		String header = header_element.getText();
		return header;
	}
	public void selectdepartdate(String departdate) {
		String header = getTextheader();
		while(true) 
		{
			header = header_element.getText();
			if (departdate.equals(header))
			{
				break;
			}
			else
			{
				forwardbtn.click();
			}
		}
	}
	public void selectdepartday(String departday) {
		
		for(WebElement day:lstday) 
		{
			if(departday.equals(day.getAttribute("data-day")))
			{
				day.click();
				break;
			}
		}
	}
	public void selectreturndate(String returndate) {
		String header = getTextheader();
		while(true) 
		{
			header = header_element.getText();
			if (returndate.equals(header))
			{
				break;
			}
			else
			{
				forwardbtn.click();
			}
		}
	}
	public void selectreturnday(String returnday) {
		
		for(WebElement day:lstday) 
		{
			if(returnday.equals(day.getAttribute("data-day")))
			{
				day.click();
				break;
			}
		}
	}
	
	public void clickdonebtn() {
		donebtn.click();
	}
	public String getresulttext() {
		String resulttxt = result.getText();
		return resulttxt;
	}
		
	public void clickFirstResult() {
		firstresult.click();
	}
	public void chooseFlight() {
		firstflight.click();
	}
	public void clickNoBtn() {
		nobtn.click();
	}
	public void clickReturnFlightResult() {
		returningflighttab.click();
	}
	public boolean checkListFlightPresent() {
		if(listflight.isDisplayed())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	}
	
	

