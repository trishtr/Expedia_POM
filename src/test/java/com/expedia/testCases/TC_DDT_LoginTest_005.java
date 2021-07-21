package com.expedia.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.expedia.pageObjects.LoginPage;
import com.expedia.testUtilis.XLSUtils;

public class TC_DDT_LoginTest_005 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void DDTLoginTest(String e_mail, String pwd) throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
		if(lp.checkSignBtnPresent())
		{
			lp.clickSigninbtn();
		}
		else 
		{
			lp.clickSignInTab();
			lp.clickSigninbtn();
		}
		
		lp.setEmail(e_mail);
		lp.setPassword(pwd);
		lp.clickSubmitbtn();
				
		if(driver.getTitle().equals("Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More")) 
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
			lp.clickUserAcc();
			lp.clickSignoutbtn();
		}
		else 
		{
			captureScreen(driver, "LoginDataTest");
			Assert.assertFalse(false);
			logger.info("Test is failed");
			
	}				
	}
				
	
	@DataProvider(name="LoginData")
	String[][] getTestData() throws IOException {
		XLSUtils xlu = new XLSUtils();
		String path = System.getProperty("user.dir") + "/src/test/java/com/expedia/testData/LoginDataExpedia.xlsx";
		int rowcount = xlu.getRowCount(path, "Sheet1");
		int colcount = xlu.getCellCount(path, "Sheet1", 1 );
		String logindata [][] = new String[rowcount][colcount];
		for(int r = 1; r<= rowcount; r++)
		{
			for(int c = 0; c < colcount; c++)
			{
				logindata[r-1][c] = XLSUtils.getCellData(path, "Sheet1", r, c);
			}
		}
		return logindata;
	}
}
