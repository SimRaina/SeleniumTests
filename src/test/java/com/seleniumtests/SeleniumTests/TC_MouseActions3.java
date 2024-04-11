package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_MouseActions3 extends BaseClass {

    static String browser = "chrome";
    static String url = "https://jqueryui.com/slider/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMouseActionsSlider() throws InterruptedException {

        WebElement frame1 = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame1);

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));

        Actions action = new Actions(driver);

        action.dragAndDropBy(slider, 500, 0).perform();
        Thread.sleep(4000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
