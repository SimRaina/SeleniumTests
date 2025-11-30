package com.seleniumtests.JavaStreamsUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;


public class ProductSortingOptimized {
	
	WebDriver driver;
	String URL = "https://demowebshop.tricentis.com/jewelry";
	
	@Test
    public void productSortingAZTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // BEFORE SORTING (raw UI data)
        List<String> beforeSort = getProductNames(driver);

        System.out.println("Products BEFORE sorting: ");
        beforeSort.forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        // MANUAL EXPECTED SORT (A → Z)
        List<String> expectedSorted =
                beforeSort.stream()
                        //.sorted()
                        .toList();
        
        // APPLY SORT ON UI
        Select sortDropDown = new Select(driver.findElement(By.id("products-orderby")));
        sortDropDown.selectByVisibleText("Name: A to Z");

        // AFTER SORTING (UI result)
        List<String> afterSort = getProductNames(driver);

        System.out.println("Products AFTER sorting: ");
        afterSort.forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        
        // VALIDATION
        if (expectedSorted.equals(afterSort)) {
            System.out.println("PASS: UI sorting A to Z works correctly!");
        } else {
            System.out.println("FAIL: UI sorting does NOT match expected A to Z result!");
            printSortingDifferences(expectedSorted, afterSort);
        }

        driver.quit();

    }
	
	private List<String> getProductNames(WebDriver driver) {
		
		return driver.findElements(By.xpath("//h2[@class='product-title']")).stream()
	            .map(WebElement::getText)
	            .toList();
	}
	
	private void printSortingDifferences(List<String> expected, List<String> actual) {

	    System.out.println("========== SORTING DIFFERENCES ==========");

	    // Items that UI added incorrectly
	    List<String> unexpected =
	            actual.stream()
	                  .filter(item -> !expected.contains(item))
	                  .toList();

	    if (!unexpected.isEmpty()) {
	        System.out.println("Unexpected items shown by UI:");
	        unexpected.forEach(System.out::println);
	    }

	    // Items skipped by UI
	    List<String> missing =
	            expected.stream()
	                    .filter(item -> !actual.contains(item))
	                    .toList();

	    if (!missing.isEmpty()) {
	        System.out.println("Items missing in UI sorted list:");
	        missing.forEach(System.out::println);
	    }

	    // Position differences
	    System.out.println("Position mismatches:");
	    int size = Math.min(expected.size(), actual.size());
	    for (int i = 0; i < size; i++) {
	        if (!expected.get(i).equals(actual.get(i))) {
	            System.out.println("At index " + i +
	                               " Expected: " + expected.get(i) +
	                               " | Actual: " + actual.get(i));
	        }
	    }

	    System.out.println("==========================================");
	}

}
