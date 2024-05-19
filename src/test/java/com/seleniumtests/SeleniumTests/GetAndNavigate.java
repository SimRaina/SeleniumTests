package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAndNavigate {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		testGetAndNavigate();
	}
	
	static void testGetAndNavigate() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window
		
		// get to open/launch url
		driver.get("https://demo.nopcommerce.com");
		
		// getTitle to get/procure the title of the current web page
		String actual_title = driver.getTitle();
		if (actual_title.equals("nopCommerce demo store")) {
			System.out.println("Title match! Test Passed");
		}else {
			System.out.println("Title don't match! Test Failed");
		}
		
		//getCurrentUrl to get current web page url
		String current_url = driver.getCurrentUrl();
		System.out.println("Current URL is: " + current_url);	
		
		// navigate methods
		// 1. navigate().to() - do same like get() to open/launch url
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000); // to put hard sleep/wait
		
		// 2. navigate().back() - to go back to first url in browser history
		driver.navigate().back();
		Thread.sleep(2000);
		
		// 3. navigate().forward() - to go forward in the browser history
		driver.navigate().forward();
		Thread.sleep(2000);
		
		// 4. navigate().refresh() - to reload the current web page
		driver.navigate().refresh();
		
		driver.close(); // close the driver instance
	}

}
