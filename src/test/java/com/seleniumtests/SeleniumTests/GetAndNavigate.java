package com.seleniumtests.SeleniumTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAndNavigate extends BaseClass {

	static String browser = "chrome";
	static String url = "https://demo.nopcommerce.com";
	
	@BeforeTest
    public static void preCondition(){

        init(browser, url);
    }
	
	@Test
	static void testGetAndNavigate() throws InterruptedException {
		
		// getTitle to get/procure the title of the current web page
		String actual_title = driver.getTitle();
		assertEquals(actual_title, "nopCommerce demo store", "Title didn't match!!");
		
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
