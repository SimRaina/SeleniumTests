package com.seleniumtests.SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLocators extends BaseClass {

	static String browser = "chrome";
	static String url = "https://demo.nopcommerce.com/";
	
	@BeforeTest
    public static void preCondition(){

        init(browser, url);
    }
	
	@Test
	static void testLocators() {
		// id
		WebElement input = driver.findElement(By.id("small-searchterms"));
		input.sendKeys("seniorqa");  // enter value
		
		// name
		WebElement input1 = driver.findElement(By.name("q"));
		input1.sendKeys("seniorqa");  // enter value
		
		// classname
		WebElement register = driver.findElement(By.className("ico-register"));
		register.click(); // click register link
		
		// linktext
		WebElement login = driver.findElement(By.linkText("Log in"));
		login.click();
		
		// partial link text
		WebElement login1 = driver.findElement(By.partialLinkText("Log"));
		login1.click();
		
		// tag name - find total links in the page
		List<WebElement> all_links = driver.findElements(By.tagName("a"));
		System.out.println("Total link:" + all_links.size());
		
		// bonus
		driver.findElement(By.name("q")).sendKeys("seniorqa");
		driver.findElement(By.partialLinkText("Log")).click();
		
		
	}

}
