package com.seleniumtests.SeleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLocatorsAdvancedNotes extends BaseClass {

	static String browser = "chrome";
	static String url = "https://demo.nopcommerce.com/";
	
	@BeforeTest
    public static void preCondition(){

        init(browser, url);
    }
	
	@Test
	static void testLocatorsXPath() throws InterruptedException {
		
		// The ByChained class enables you to chain two By locators together
		By example = new ByChained(By.id("login-form"), By.id("username-field"));
        WebElement username_input = driver.findElement(example);
        
        /* The ByAll class enables you to utilize two By locators at once, 
           finding elements that match either of your By locators */
        By example1 = new ByAll(By.id("password-field"), By.id("username-field"));
        List<WebElement> login_inputs = driver.findElements(example);
        
        // Relative Locator
        By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
        
        By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
        
        By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
        
        By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
        
        By emailLocator1 = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));
        
        // Chaining Relative Locators
        By submitLocator1 = RelativeLocator.with(By.tagName("button"))
        		                          .below(By.id("email"))
        		                          .toRightOf(By.id("cancel"));
	}

}
