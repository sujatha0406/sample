package com.practice.sample;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;


public class BaseTest4 {
	
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentProp;
	public static Properties childProp;
	public static Properties orProp;
	
	public static void init() throws Exception
	{
		 fis = new FileInputStream(projectPath + "/data.properties");
		 p=new Properties();
		p.load(fis);
		
		
		fis = new FileInputStream(projectPath + "/environment.properties");
		 parentProp = new Properties();
		parentProp.load(fis);
		String e=parentProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath + "/"+e+".properties");
		 childProp=new Properties();
		childProp.load(fis);
		String value=childProp.getProperty("amazonurl");
		System.out.println(value);
		
	}
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/selenium/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			option.addArguments("----disable-notifications");
			driver=new ChromeDriver(option);
			
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/selenium/geckodriver.exe");
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("SeleniumProfile");
			profile.setPreference("dom.webnotifications.enabled",false);
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
		
  			driver=new FirefoxDriver(option);
		}
			
		}

	public static void navigateUrl(String url)
	{
		
		driver.navigate().to(childProp.getProperty(url));
      

}
	public static void clickElement(String locatorKey) 
	{
		driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}
	public static void type(String locatorKey, String text) 
	{
		driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}
	public static void selectOption(String locatorKey, String item) 
	{
		driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(item);
	}

}
