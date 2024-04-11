package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_MouseActions1 extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demoqa.com/tool-tips";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMouseActions1() throws InterruptedException {

        Actions action = new Actions(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver; // down casting or narrow type conversion

        // hover
        WebElement hover_ele = driver.findElement(By.id("toolTipButton"));

        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("text-center")));
        
        action.moveToElement(hover_ele).perform(); // perform() is compulsory for mouse action
        Thread.sleep(2000);


        // right click
          WebElement rt_click = driver.findElement(By.id("texFieldToolTopContainer"));
          action.contextClick(rt_click).perform();
         Thread.sleep(2000);

        
      // action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform(); // build().perform() for multiple methods / mouse actions
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
