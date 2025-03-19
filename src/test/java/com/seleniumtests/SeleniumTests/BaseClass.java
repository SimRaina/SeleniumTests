package com.seleniumtests.SeleniumTests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    static WebDriver driver;

    public static void initChrome(){
        driver = new ChromeDriver(); // create instance of chromeDriver and assign to WebDriver ref. variable
        driver.get("https://demo.nopcommerce.com/"); // open this url
        driver.manage().window().maximize(); // maximizing the window
    }
    
    public static void init(String browser, String url){
        if(browser.equalsIgnoreCase("chrome")) {
        	driver = new ChromeDriver(); 
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
             HttpURLConnection connection = (HttpURLConnection) new URL(link).openConnection();
             connection.setConnectTimeout(3000); 
             connection.connect();
             if(connection.getResponseCode()==HttpURLConnection.HTTP_OK) // active link condition
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
