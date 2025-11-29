package com.seleniumtests.JavaStreamsUITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductFilteringOptimizedTest {

	WebDriver driver; 
	String URL = "https://demowebshop.tricentis.com/desktops";
	
	@Test
    public void productFilterPriceTest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        // --- BEFORE FILTER ---
        System.out.println("Products with Prices BEFORE Applying Filter:");

        Map<String, Double> beforeFilter = extractProductInfo(driver);
        beforeFilter.forEach((name, price) ->
                System.out.println(name + " -> " + price));

        System.out.println("---------------------------------------------------");

        // --- APPLY PRICE FILTER ---
        driver.findElement(By.xpath("//ul[@class='price-range-selector']//li[1]/a")).click();
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("remove-price-range-filter")
                ));

        // --- AFTER FILTER ---
        System.out.println("Products with Prices AFTER Applying Filter:");

        Map<String, Double> afterFilter = extractProductInfo(driver);
        afterFilter.forEach((name, price) ->
                System.out.println(name + " -> " + price));

        System.out.println("---------------------------------------------------");
        System.out.println("Products with Prices After Applying any Manual Filter in Code : ");

        Map<String, Double> manualFilterBefore =
                beforeFilter.entrySet().stream()
                        .filter(e -> e.getValue() < 1000.00)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        ));

        manualFilterBefore.forEach((k, v) -> System.out.println(k + " -> " + v));
        
        System.out.println("---------------------------------------------------");
        if (manualFilterBefore.equals(afterFilter)) {
            System.out.println("Filtering works Correctly! ");
        }
        driver.quit();

    }
	
	private Map<String, Double> extractProductInfo(WebDriver driver) {

	    return driver.findElements(By.xpath("//div[@class='details']")).stream()
	            .collect(Collectors.toMap(
	                    item -> item.findElement(By.tagName("h2")).getText(),
	                    item -> {
	                        String priceText = item.findElement(By.tagName("span")).getText();
	                        // remove currency symbols like ₹, $, £, etc.
	                        priceText = priceText.replaceAll("[^0-9.]", "");
	                        return Double.parseDouble(priceText);
	                    }
	            ));
	}

}
