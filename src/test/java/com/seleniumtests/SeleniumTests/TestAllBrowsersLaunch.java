package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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

        driver = WebDriverManager.chromedriver().create();
        driver = new ChromeDriver(); // create instance of chromeDriver and assign to WebDriver ref. variable


        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize(); // maximizing the window

    }

    static void testFirefox(){

    	driver = WebDriverManager.firefoxdriver().create();
        driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize();

    }

    static void testIE(){

    	driver = WebDriverManager.iedriver().create();
        driver = new InternetExplorerDriver();
        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize();

    }

    static void testEdge(){

    	driver = WebDriverManager.edgedriver().create();
        driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/"); // open this url
        driver.manage().window().maximize();
    }

    static void closeBrowser(){

      driver.close();
    }
}
