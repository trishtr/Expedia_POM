package com.expedia.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(how= How.XPATH, using = "//a[contains(text(),'Sign in')]")
	WebElement signinbtn ;
	
	@FindBy(id="signin-loginid")
	WebElement emailAddresstxt;
	
	@FindBy(id="signin-password")
	WebElement passwordtxt;
	
	@FindBy(id = "submitButton")
	WebElement submitbtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='uitk-text uitk-type-300'][@xpath='1']")
	WebElement useracc;
	
	@FindBy(how=How.XPATH, using = "//a[@aria-label='Sign out']")
	WebElement signoutbtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Sign in')]")
	WebElement signintab;
	
	public void clickSigninbtn() {
		signinbtn.click();
	}
	
	public void setEmail(String email) {
		emailAddresstxt.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		passwordtxt.sendKeys(pwd);
	}
	
	public void clickSubmitbtn(){
		submitbtn.click();
	}
	
	public void clickUserAcc() {
		useracc.click();
	}
	public void clickSignoutbtn() {
		signoutbtn.click();
	}
	public void clickSignInTab() {
		signintab.click();
	}
	public boolean checkSignBtnPresent() {
		if (signinbtn.isDisplayed()) {
			return true;
		}
		else
		{
			return false;
		}
	}
}
