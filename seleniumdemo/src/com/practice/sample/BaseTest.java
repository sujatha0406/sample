package com.practice.sample;

import java.io.FileInputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	
	public static void init() throws Exception
	{
		FileInputStream fis=new FileInputStream(projectPath + "/data.properties");
		Properties p=new Properties();
		p.load(fis);
	}
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/selenium/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			
			driver=new ChromeDriver(option);
			
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/selenium/geckodriver.exe");
  			driver=new FirefoxDriver();
		}
			
		}

	public static void navigateUrl(String url)
	{
       driver.get(p.getProperty(url));
}
}