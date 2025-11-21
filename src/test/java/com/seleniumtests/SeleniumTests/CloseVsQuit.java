package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CloseVsQuit extends BaseClass{

	static String browser = "chrome";
	static String url = "https://demoqa.com/browser-windows";
	
	@BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

	@Test
	static void testCloseVsQuit() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(2000);
		// driver.close(); // closes first page/tab
		driver.quit(); // closes both tabs/ all tabs opened by the driver instance
	}
}
