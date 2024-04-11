package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_AlertTestChrome extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demoqa.com/alerts";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testAlert1() throws InterruptedException {
        // Normal Alert with only OK
    	WebElement alertbutton=driver.findElement(By.id("alertButton"));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	// Need to use JSE as click is not interactable error is faced
    	js.executeScript("arguments[0].click();", alertbutton);
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept(); // click OK
        
        // get text
        WebElement confirmbutton = driver.findElement(By.id("confirmButton"));
        js.executeScript("arguments[0].click();", confirmbutton);
        String text = alert.getText();
        System.out.println(text);

        alert.accept(); // OK

        js.executeScript("arguments[0].click();", confirmbutton);
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss(); // cancel

        Thread.sleep(2000);

        WebElement promptbutton = driver.findElement(By.id("promtButton"));
        js.executeScript("arguments[0].click();", promptbutton);

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("seniorQA"); // not working in chrome

        Thread.sleep(2000);

        String str = driver.switchTo().alert().getText();
        System.out.println(str);

        driver.switchTo().alert().accept(); // clicking on OK

        Thread.sleep(2000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }


}
