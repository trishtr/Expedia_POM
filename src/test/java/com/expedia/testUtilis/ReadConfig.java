package com.expedia.testUtilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadConfig {
		
	Properties pro;
	
	public ReadConfig(){
		
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);	
			}
		catch (IOException e) 
		{
			System.out.println("Exception is " + e.getMessage());
		}
		
		}
	
	public String getURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	public String getFireFoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getBrowser()
	{
		String browser = pro.getProperty("browser");
		return browser;
	}
	
			

		
		
}
