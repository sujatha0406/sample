package com.practice.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleProgram {
	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/selenium/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/user/Desktop/selenium/geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("https://www.flipkart.in");
	
		
		
		}
		}

	
