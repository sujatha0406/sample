package com.practice.sample;

import org.openqa.selenium.By;

public class TC_002 extends BaseTest2 {

	public static void main(String[] args) throws Exception {
		init();
		
		launch("firefoxbrowser");
		
		navigateUrl("hdfcurl");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.linkText("KNOW MORE")).click();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		Thread.sleep(4000);
		
		driver.navigate().forward();
		Thread.sleep(4000);
		
		driver.navigate().refresh();
		

		//driver.close();
	}
	

}
