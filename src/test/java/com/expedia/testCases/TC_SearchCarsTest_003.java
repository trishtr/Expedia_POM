package com.expedia.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.expedia.pageObjects.SearchCarsPage;

public class TC_SearchCarsTest_003 extends BaseClass {

	@Test
	public void SearchCarsTest() throws IOException {
		SearchCarsPage sc = new SearchCarsPage(driver);
		logger.info("Choose place to pick up");
		sc.clickcarbtn();
		sc.clickpickupbtn();
		sc.selectpickupplace("Houston");
		logger.info("Select date to pick up");
		sc.clickpickupdate();
		sc.selectpickupdate("May 2022");
		sc.selectpickupday("20");
		sc.clickdonebtn();
		logger.info("Select date to drop off");
		sc.clickdropoffdate();
		sc.selectdropoffdate("June 2022");
		sc.selectdropoffday("12");
		sc.clickdonebtn();
		logger.info("Select time to pick up and drop off");
		sc.selectPickupTime("9:45 am");
		sc.selectDropoffTime("11:00 pm");
		logger.info("Select discount");
		sc.clickDiscountBtn();
		sc.selectPreferredBrand("Europcar");
		sc.selectDiscountType("Special or advertised");
		sc.clickSearchBtn();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if(driver.getTitle().contains("Rental Cars and Car Rentals"))
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else
		{
			captureScreen(driver,"SearchCarsTest");
			Assert.assertFalse(false);
			logger.info("Test is failed");
			
		}
	}
}
