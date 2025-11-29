package com.seleniumtests.JavaStreamsUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;


public class ProductSortingTest {
	
	WebDriver driver;
	String URL = "https://demowebshop.tricentis.com/jewelry";
	
	@Test
    public void productSortingAZTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        List<WebElement> product_items_before_sort = driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<String> product_names_before_sort = product_items_before_sort.stream().map(i -> i.getText()).sorted().toList();

        System.out.println("Products Before Sorting: ");
        product_items_before_sort.forEach(i -> System.out.println(i.getText()));

        System.out.println("---------------------------------------------------");
        //Selecting the sort option on UI
        Select sortbydrp = new Select(driver.findElement(By.id("products-orderby")));
        sortbydrp.selectByVisibleText("Name: A to Z");

        List<WebElement> product_items_after_sort = driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<String> product_names_after_sort = product_items_after_sort.stream().map(i -> i.getText()).toList();

        System.out.println("Products After Sorting: ");
        product_names_after_sort.forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        if (product_names_before_sort.equals(product_names_after_sort)) {
            System.out.println("Alphabetical sorting works correctly! ");
        }

        driver.quit();

    }
}
