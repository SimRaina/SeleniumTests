package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConditionalTest extends BaseClass {


    static String browser = "Chrome";
    static String url1 = "https://demo.nopcommerce.com";

    @BeforeTest
    public static void preCondition(){

        init(browser, url1);

    }

    @Test
    public static void getCommands() throws InterruptedException { // Test Method

        driver.findElement(By.className("ico-register")).click();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl(); // get the url
        System.out.println("Current URL is: " + url);

        // Condition methods

        Boolean disp = driver.findElement(By.id("FirstName")).isDisplayed();
        System.out.println(disp);

        Boolean enable = driver.findElement(By.name("register-button")).isEnabled();
        System.out.println(enable);

        WebElement gender = driver.findElement(By.cssSelector("input[value=M]"));
        Boolean select = gender.isSelected();

        System.out.println("Checkbox is selected: " + select);

        if(select == false){

            gender.click();
            select = gender.isSelected();
            System.out.println("Checkbox is selected: " + select);
            assertTrue(select);

        }
    }

    @AfterTest
    public static void postCondition(){

        closeBrowser();

    }

}
