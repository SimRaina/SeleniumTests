package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestAllBrowsersLaunch {


    static WebDriver driver;

    public static void main(String[] args) {

        testChrome();
        // testFirefox();
        // testIE();
        // testEdge();
        closeBrowser();
    }

    static void testChrome(){

    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); // create instance of chromeDriver and assign to WebDriver ref. variable


        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize(); // maximizing the window

    }

    static void testFirefox(){

        driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize();

    }

    static void testIE(){

        driver = new InternetExplorerDriver();
        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize();

    }

    static void testEdge(){

        driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize();
    }

    static void closeBrowser(){

      driver.close();
    }
}
