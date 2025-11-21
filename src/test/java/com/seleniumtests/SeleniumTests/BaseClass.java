package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
        
        else if(browser.equalsIgnoreCase("edge")) {
        	driver = new EdgeDriver();
        }
        driver.get(url); // open this url
        driver.manage().window().maximize(); // maximizing the window
    }

    public static void closeBrowser(){
        driver.close();
    }
}
