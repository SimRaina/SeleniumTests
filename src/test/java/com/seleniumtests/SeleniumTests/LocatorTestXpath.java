package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;

public class LocatorTestXpath extends BaseClass{


    public static void main(String[] args) throws InterruptedException {

        initChrome();
        testXpath(); // main test method
        closeBrowser();
    }

    public static void testXpath() throws InterruptedException{

        // driver.findElement(By.xpath("//div[2]/div[1]/ul/li[1]/a")).click();
        // driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // driver.findElement(By.xpath("//a[text()= 'Log in']")).click(); // use complete name of the text

        driver.findElement(By.xpath("//input[contains(@class, 'search-box')]")).sendKeys("seniorqa");

        Thread.sleep(2000);

    }
}
