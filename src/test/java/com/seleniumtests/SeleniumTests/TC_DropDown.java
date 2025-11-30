package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_DropDown extends BaseClass {

    static String browser = "chrome";
    static String url = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";

    @BeforeTest
    public static void preCondition(){
        init(browser, url);
    }

    @Test
    public static void testDropDown() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	       By.xpath("//button[contains(., 'Accept') or contains(., 'Consent')]")
    	    ));
    	acceptBtn.click();

        WebElement country_list = driver.findElement(By.xpath("//select"));
        Select select_country = new Select(country_list);

        select_country.getOptions().stream()
        .map(WebElement::getText)
        .forEach(System.out::println);

        select_country.selectByIndex(2); // by index selecting the single option from the list
        Thread.sleep(1000);
        select_country.selectByValue("BHR");
        Thread.sleep(1000);
        select_country.selectByVisibleText("China");
        Thread.sleep(1000);
    }

    @AfterTest
    public void postCondition(){
       closeBrowser();
    }
}
