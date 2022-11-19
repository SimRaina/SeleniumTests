package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;

public class LocatorTest2CSS extends BaseClass{

    public static void main(String[] args) throws InterruptedException {

    initChrome();
    testCSS();
    closeBrowser();
    }

    public static void testCSS() throws InterruptedException {

        // tag and id
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("BusyQA");
        Thread.sleep(2000);

        // tag and class
        driver.findElement(By.cssSelector("a.ico-register")).click();
        Thread.sleep(2000);
        // tag and attribute
        driver.findElement(By.cssSelector("input[name=FirstName]")).sendKeys("Simran");
        Thread.sleep(2000);
        // tag class/id and attribute
        driver.findElement(By.cssSelector("input#LastName[name=LastName]")).sendKeys("Raina");
        Thread.sleep(2000);

    }
}
