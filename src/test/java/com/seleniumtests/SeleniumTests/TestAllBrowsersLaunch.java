package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAllBrowsersLaunch {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		testChrome();
		testFirefox();
		testEdge();
	}
	
	static void testChrome() {
		
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
	}
	
	static void testFirefox() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.selenium.dev/");
	}
	
	static void testEdge() {
		
		driver = new EdgeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
	}

}
