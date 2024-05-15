package com.seleniumtests.SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocators {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		testLocators();
	}
	
	static void testLocators() {
		
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// id
		WebElement input = driver.findElement(By.id("small-searchterms"));
		// input.sendKeys("seniorqa");  // enter value
		
		// name
		WebElement input1 = driver.findElement(By.name("q"));
		// input1.sendKeys("seniorqa");  // enter value
		
		// classname
		WebElement register = driver.findElement(By.className("ico-register"));
		// register.click(); // click register link
		
		// linktext
		WebElement login = driver.findElement(By.linkText("Log in"));
		// login.click();
		
		// partial link text
		WebElement login1 = driver.findElement(By.partialLinkText("Log"));
		// login1.click();
		
		// tag name - find total links in the page
		List<WebElement> all_links = driver.findElements(By.tagName("a"));
		System.out.println("Total link:" + all_links.size());
		
		// bonus
		driver.findElement(By.name("q")).sendKeys("seniorqa");
		driver.findElement(By.partialLinkText("Log")).click();
		
		
	}

}
