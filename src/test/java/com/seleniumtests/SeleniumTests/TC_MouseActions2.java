package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_MouseActions2 extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demoqa.com/droppable";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMouseActions1() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver; // down casting or narrow type conversion

       Actions action = new Actions(driver);

        // drag and drop
        Thread.sleep(2000);

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("text-center")));
        
        Thread.sleep(2000);
        
        action.dragAndDrop(drag, drop).perform();
     // action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform(); // build().perform() for multiple methods / mouse actions
        Thread.sleep(2000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
