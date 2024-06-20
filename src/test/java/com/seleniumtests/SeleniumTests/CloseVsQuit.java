package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuit {

	static WebDriver driver;
	static String url = "https://demoqa.com/browser-windows";
	
	public static void main(String[] args) throws InterruptedException {
		
		testCloseVsQuit();
	}

	static void testCloseVsQuit() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(2000);
		// driver.close(); // closes first page/tab
		driver.quit(); // closes both tabs/ all tabs opened by the driver instance
	}
}
