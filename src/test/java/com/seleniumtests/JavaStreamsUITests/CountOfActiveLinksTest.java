package com.seleniumtests.JavaStreamsUITests;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.seleniumtests.SeleniumTests.BaseClass;


public class CountOfActiveLinksTest extends BaseClass{
	
	static String browser = "chrome";
    static String url = "https://www.google.com/";

    @BeforeTest
    public static void preCondition(){
        init(browser, url);
    }
	
    @Test
	public static void test() {
		driver.findElements(By.tagName("a")).stream()
        .map(link -> link.getAttribute("href"))               // extract href
        .filter(Objects::nonNull)                             // remove nulls
        .filter(href -> !href.isBlank())                      // remove empty values
        .forEach(href -> checkLink(href));                    // validate		
	}
	
	private static void checkLink(String href) {
	    try {
	        URI uri = URI.create(href);
	        URL url = uri.toURL();

	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.setConnectTimeout(5000);
	        conn.connect();

	        int status = conn.getResponseCode();

	        if (status >= 200 && status < 400) {
	            System.out.println(url + " → ACTIVE (" + status + ")");
	        } else {
	            System.out.println(url + " → BROKEN (" + status + ")");
	        }

	    } catch (Exception e) {
	        System.out.println(href + " → ERROR: " + e.getMessage());
	    }
	}
}
