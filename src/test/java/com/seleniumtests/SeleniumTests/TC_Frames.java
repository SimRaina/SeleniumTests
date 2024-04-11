package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TC_Frames extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demoqa.com/frames";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testFrames() throws InterruptedException {

        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1); // frame1 is id of the frame

        // driver.switchTo().frame(0); // also can use index

        String text_inside_frame=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text_inside_frame);
        Thread.sleep(2000);

        driver.switchTo().defaultContent(); // bring the control/focus outside the frame back to the web page
        Thread.sleep(2000);
        
        WebElement frame2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2); // frame2 is id of the frame
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
