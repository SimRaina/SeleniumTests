package com.test.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocatorsXpath {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		testLocatorsXPath();

	}
	
	static void testLocatorsXPath() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		
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
