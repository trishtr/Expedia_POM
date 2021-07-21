package com.expedia.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.expedia.testUtilis.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;
	public String baseURL = readconfig.getURL();
	public String email = readconfig.getEmail();
	public String password = readconfig.getPassword();

	public static Logger logger;
	
	
	@BeforeClass
	public void setUp()
	{
		logger = Logger.getLogger("expediaTesting");
		PropertyConfigurator.configure("log4j.properties");
		ReadConfig readconfig = new ReadConfig();
		String br = readconfig.getBrowser();
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}	
		
		driver.get(baseURL);

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
		
	}
	
	
}
