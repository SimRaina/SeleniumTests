package com.seleniumtests.SeleniumTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorTest1 extends BaseClass{


    public static void main(String[] args) throws InterruptedException{

        initChrome();
        testLocators();
        closeBrowser();
    }


    public static void testLocators() throws InterruptedException {

        // by id
        // driver.findElement(By.id("small-searchterms")).sendKeys("seniorqa"); // locating the element and taking action
       WebElement searchBox = driver.findElement(By.id("small-searchterms"));
       searchBox.sendKeys("seniorqa");
       Thread.sleep(2000);

       // by class
       // WebElement searchButton = driver.findElement(By.className("button-1 search-box-button"));
        // searchButton.click();

        // WebElement searchBox1 = driver.findElement(By.className("search-box-text ui-autocomplete-input"));
        // searchBox1.clear();
        Boolean display = driver.findElement(By.className("header-lower")).isDisplayed();
        System.out.println(display);


        // by name
        driver.findElement(By.name("q")).clear();
        Thread.sleep(2000);

        // by tagName
        // How to get the count/size of links used in a webpage (How many HTML anchor tag elements are present?)

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int count = links.size();
        System.out.println("Count of the links: " + count);

        // linkText
        driver.findElement(By.linkText("Register")).click(); // use complete and correct case name of the text
        Thread.sleep(2000);

        // partialLinkText
        driver.findElement(By.partialLinkText(" in")).click();
        Thread.sleep(2000);
    }
}
