package com.practice.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_004 extends BaseTest4 {

	public static void main(String[] args) throws Exception {
              init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		loc.sendKeys("Books");
		
		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]")).click();
		

	}
	}


