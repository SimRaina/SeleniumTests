package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLocatorsCSS extends BaseClass {

	static String browser = "chrome";
	static String url = "https://demo.nopcommerce.com/";
	
	@BeforeTest
    public static void preCondition(){

        init(browser, url);
    }
	
	@Test
	static void testLocatorsCSS() throws InterruptedException {
		
		// 1. Tagname+ID - in CSS id is represented/denoted by # [hash]
		
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("seniorqa"); // tagname#idvalue
		Thread.sleep(2000);
		
		// 2. Tagname+Class - in CSS class is represented/denoted by . [dot]
		
		driver.findElement(By.cssSelector("a.ico-register")).click(); // tagname.classvalue
		Thread.sleep(2000);
		
		// 3. Tagname+OtherAttribute - other than id or class
		
		driver.findElement(By.cssSelector("input[name=FirstName]")).sendKeys("Sim");  // tagname[attribute=value]
		Thread.sleep(2000);
		
		// 4. Tagname+ID/Class+Tagname+Other attribute - combination of above
		
		driver.findElement(By.cssSelector("input#LastName[name=LastName]")).sendKeys("Raina"); // tagname#idvalue[attr=value] 
		Thread.sleep(2000);
		
		// Bonus - Advanced CSSSelector
		// Partial match:
		/* ^= matches the start of the value.
		$= matches the end of the value.
		*= matches any part of the value. */ 
		
		// driver.findElement(By.cssSelector("[href^='/login']")).click(); // [attr^='startvalue']
		// driver.findElement(By.cssSelector("[href*='login?']")).click();
		driver.findElement(By.cssSelector("[class$='login']")).click();
    
	}

}
