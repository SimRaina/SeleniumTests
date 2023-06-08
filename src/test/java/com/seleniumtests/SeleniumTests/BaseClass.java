package com.seleniumtests.SeleniumTests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    static WebDriver driver;


    public static void initChrome(){
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options); // create instance of chromeDriver and assign to WebDriver ref. variable


        driver.get("http://uitestpractice.com/Students/Widgets"); // open this url
        driver.manage().window().maximize(); // maximizing the window
    }
    public static void init(String browser, String url){
    	
        if(browser.equalsIgnoreCase("chrome")) {
        	
        	ChromeOptions options = new ChromeOptions();
        	// Launch Chrome error - Fix #1
        	// options.addArguments("--remote-allow-origins=*");
        	
        	// Launch Chrome error - Fix #2
        	System.setProperty("webdriver.http.factory", "jdk-http-client");
        	
        	options.addArguments("--disable-notifications");
        	
            driver = new ChromeDriver(options); // create instance of chromeDriver and assign to WebDriver ref. variable
        }
        
        
        else if(browser.equalsIgnoreCase("firefox")) {
        	driver = new FirefoxDriver();
        }


        driver.get(url); // open this url
        driver.manage().window().maximize(); // maximizing the window
    }
    
    public static void verifyLinks(String link) {
    	 try
         {
             URL url1 = new URL(link);

             URLConnection url2 = url1.openConnection();

             HttpURLConnection httpURLConnect=(HttpURLConnection)url2; // create connection -> type casting from variable of one class type to another class type

             httpURLConnect.setConnectTimeout(3000); // wait for the response - 3 seconds

             httpURLConnect.connect(); // triggering/hitting the links in the backend

             if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_OK) // active link condition
             {
                 System.out.println(link+": "+httpURLConnect.getResponseMessage()); // message is success
             }
             else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  // only checking for 404 for broken links
             {
                 System.out.println(link+": "+httpURLConnect.getResponseMessage() + " : "+ HttpURLConnection.HTTP_NOT_FOUND);
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
    }

    public static void closeBrowser(){
        driver.close();
    }
}
