package com.seleniumtests.SeleniumTests;


import org.testng.annotations.Test;

public class TestAllBrowsersLaunch extends BaseClass {
	
    static String browser;
	static String url = "https://www.selenium.dev/";
	@Test
	static void testChrome() {
		browser = "chrome";
		init(browser, url);
	}
	
	@Test
	static void testFirefox() {
		browser = "firefox";
		init(browser, url);
	}
	
	@Test
	static void testEdge() {
		browser = "edge";
		init(browser, url);
	}

}
