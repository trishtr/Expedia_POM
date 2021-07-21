package com.expedia.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.expedia.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws IOException 
	{
		logger.info("Opening URL");
		
		LoginPage lp = new LoginPage(driver);
		lp.clickSigninbtn();
		logger.info("Click Sign in button");
		lp.setEmail(email);	
		logger.info("Entered email");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmitbtn();
		logger.info("Click submit button");
		
		if(driver.getTitle().equals("Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More")) 
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else 
		{
			captureScreen(driver, "LoginTest");
			Assert.assertFalse(false);
			logger.info("Test is failed");
			
	}
	
	
		
	}
}

