package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocatorsCSS {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		testLocatorsCSS();

	}
	
	static void testLocatorsCSS() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		
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
