package com.practice.sample;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest2 {

	
		public static WebDriver driver;
		public static String projectPath=System.getProperty("user.dir");
		public static FileInputStream fis;
		public static Properties p;
		public static Properties parentProp;
		public static Properties childProp;
		
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
				driver=new ChromeDriver();
				
			}
			else if(p.getProperty(browser).equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/selenium/geckodriver.exe");
	  			driver=new FirefoxDriver();
			}
				
			}

		public static void navigateUrl(String url)
		{
	       driver.get(childProp.getProperty(url));
	}
	
      
	}


