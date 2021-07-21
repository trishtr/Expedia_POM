package com.expedia.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.expedia.pageObjects.SearchFlightPage;

public class TC_ChooseFlightTest_004 extends BaseClass {

	@Test
	public void ChooseFlightTest() throws InterruptedException, IOException {
		/*LoginPage lp = new LoginPage(driver);
		lp.clickSigninbtn();
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickSubmitbtn();
		
		Thread.sleep(5000);*/
		
		SearchFlightPage sf = new SearchFlightPage(driver);
		logger.info("Choose departure and destination");
		sf.clickFlightBtn();
		sf.clickLeavingBtn();
		sf.setLeavingPlace("Anchorage");
		sf.clickGoingBtn();
		sf.setGoingPlace("San Jose");
		
		logger.info("Choose departure date");
		sf.clickdepartbtn();
		sf.getTextheader();
		sf.selectdepartdate("November 2021");
		sf.selectdepartday("18");
		sf.clickdonebtn();
		
		logger.info("Choose return date");
		sf.clickreturnbtn();
		sf.getTextheader();
		sf.selectreturndate("December 2021");
		sf.selectreturnday("25");
		sf.clickdonebtn();
		
		logger.info("Click search button");
		sf.clicksearchbtn();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		logger.info("Choose going flight");
		sf.clickFirstResult();
		sf.chooseFlight();
		Thread.sleep(5000);
		
		logger.info("Choose returning flight");
		sf.clickFirstResult();
		sf.chooseFlight();
		sf.clickNoBtn();
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Flight details | Expedia"))
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else
		{
			captureScreen(driver, "SearchFlightTest");
			Assert.assertFalse(false);
			logger.info("Test is failed");
		}
		
	}
}
