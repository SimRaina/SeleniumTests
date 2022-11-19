package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_JSExec2 extends BaseClass {

    static String browser = "chrome";
    static String url = "http://uitestpractice.com";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testDropDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver; // down casting or narrow type conversion

        js.executeScript("window.scrollBy(0,1000)"); // scroll by x,y

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.xpath("//button/a[contains(text(),'Click here')]"));

        js.executeScript("arguments[0].scrollIntoView();", button);

        Thread.sleep(3000);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(3000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
