package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class TC_CountOfActiveLinks extends BaseClass {

    static String browser = "chrome";
    static String url = "https://www.google.com/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testLinks() throws InterruptedException {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + links.size());
        
        for (WebElement link : links) {
            String href = link.getAttribute("href");

            // ignore empty or null href values
            if (href == null || href.isEmpty()) {
                System.out.println("Skipping: empty or null href");
                continue;
            }

            try {
            	URI uri = URI.create(href);
                URL url = uri.toURL(); 
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("HEAD");       // faster than GET
                conn.setConnectTimeout(5000);
                conn.connect();

                int status = conn.getResponseCode();
                if (status >= 200 && status < 400) {
                    System.out.println(url + " → ACTIVE (" + status + ")");
                } else {
                    System.out.println(url + " → BROKEN (" + status + ")");
                }

            } catch (Exception e) {
                System.out.println(url + " → ERROR: " + e.getMessage());
            }
        }
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }

}
