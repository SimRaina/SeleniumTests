package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_MultiDropDown extends BaseClass {

    static String browser = "chrome";
    static String url = "https://demoqa.com/select-menu";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testMultiDropDown() throws InterruptedException {

        WebElement cars =  driver.findElement(By.id("cars"));

        Select select_cars = new Select(cars);

        // selection multiple
        select_cars.selectByIndex(0);
        Thread.sleep(2000);
        select_cars.selectByValue("opel");
        Thread.sleep(2000);
        select_cars.selectByVisibleText("Saab");
        Thread.sleep(2000);

        // deselection
        select_cars.deselectByValue("opel");
        Thread.sleep(2000);
        select_cars.deselectAll();
        Thread.sleep(2000);
    }

    @AfterTest
    public void postCondition(){

        closeBrowser();
    }
}
