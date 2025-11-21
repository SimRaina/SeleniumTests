package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLocatorsXpath extends BaseClass {

	static String browser = "chrome";
	static String url = "https://demo.nopcommerce.com/";
	
	@BeforeTest
    public static void preCondition(){

        init(browser, url);
    }
	
	@Test
	static void testLocatorsXPath() throws InterruptedException {
		// 1. XPath with attribute
		
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("seniorqa");
		Thread.sleep(2000);
		
		// 2. XPath with text()
		driver.findElement(By.xpath("//button[text()='Search']")).click(); // click Search
		Thread.sleep(2000);
		
		// 3. XPath with contains()
		driver.findElement(By.xpath("//a[contains(@class, 'ico-register')]")).click(); // click Register
		Thread.sleep(2000);
		
		// XPath with contains + text
		driver.findElement(By.xpath("//a[contains(text(), 'Log')]")).click();  // click Log in
		Thread.sleep(2000);
		
		// 4. XPath with starts-with()
		driver.findElement(By.xpath("//a[starts-with(@href, '/register')]")).click(); // click Register
		Thread.sleep(2000);
		
		// 5. XPath with indexing
		driver.findElement(By.xpath("//div[@class='header-links']/ul/li[3]")).click(); // click Wishlist
		Thread.sleep(2000);
		
		// 6. XPath with and/or
		driver.findElement(By.xpath("//a[contains(text(), 'Log') and @class='ico-login']")).click();
		
	}

}
