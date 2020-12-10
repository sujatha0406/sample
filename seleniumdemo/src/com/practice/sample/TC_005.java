package com.practice.sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_005 extends BaseTest5 {
	public static void main(String[] args) throws Exception {
        init();
	
	launch("chromebrowser");
	
	navigateUrl("amazonurl");
	
	selectOption("amazondropdown_id","Books");
	
	type("amazonsearchtext_name","Harry Potter");

	clickElement("amazonsearchbutton_xpath");
	
	
}

}
