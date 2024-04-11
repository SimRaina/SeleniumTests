package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_AlertTestFirefox extends BaseClass {

    static String browser = "firefox";
    static String url = "https://demoqa.com/alerts";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testAlert2() throws InterruptedException {

    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	// Need to use JSE as click is not interactable error is faced
    	WebElement promptbutton = driver.findElement(By.id("promtButton"));
        js.executeScript("arguments[0].click();", promptbutton);

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("seniorqa"); // sendKeys() is working

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
