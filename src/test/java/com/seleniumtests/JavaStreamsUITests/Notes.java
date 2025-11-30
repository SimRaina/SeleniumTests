package com.seleniumtests.JavaStreamsUITests;

/* 	✔ Streams are ideal for reading and filtering, not updating elements
	✔ Prefer streams for:
	   Comparing lists, Extracting text, Validating dropdown contents, Processing tables, Searching elements

	✔ Avoid streams when:
       You need complex try/catch handling, You modify WebElements (click, sendKeys) inside map/filter
*/
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Notes {
	
	WebDriver driver;
	
	public void test() {
		
		driver = new ChromeDriver();
		// filter, forEach
		List<String> names = new LinkedList<>();
		names.stream()
	     .filter(name -> name.startsWith("A"))
	     .forEach(System.out::println);
		
		// getText()
		List<WebElement> elements = driver.findElements(By.id("id"));
		List<String> texts = elements.stream()
                .map(WebElement::getText)
                .toList();
		
		List<String> filtered = names.stream()      // source
                .filter(n -> n.length() > 3)     	// intermediate
                .map(String::toUpperCase)     		// intermediate
                .toList();    						// terminal
		
		// map
		List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();
		
		// forEach
		names.stream().forEach(System.out::println);
		
		elements.stream().forEach(e -> System.out.println(e.getText()));
		
		// distinct()
		List<String> unique = names.stream()
                .distinct()
                .toList();
		
		// findFirst() / findAny()
		Optional<String> first = names.stream()
                .filter(n -> n.startsWith("A"))
                .findFirst();
		
		String result = first.orElse("Not Found"); // error handling (in case of nulls)
		
		// anyMatch(), allMatch(), noneMatch()
		boolean allStartWithA = names.stream()
                .allMatch(n -> n.startsWith("A"));
		
		boolean allVisible = elements.stream()
                .allMatch(WebElement::isDisplayed);
		
		// limit()
		List<String> firstTwo = names.stream()
                .limit(2)
                .toList();
		
		// QA Automation Examples
		List<String> visibleTexts = elements.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .toList();
        
		Select select = new Select(driver.findElement(By.id("id")));
		List<WebElement> options = select.getOptions();
        List<String> dropDownValues = options.stream()
                .map(WebElement::getText)
                .toList();
        
		boolean hasIndia = select.getOptions().stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.equals("India"));
		
		// dropdown options are unique
		boolean noDuplicates = select.getOptions().stream()
                .map(WebElement::getText)
                .distinct()
                .count()
                == select.getOptions().size();
		
		// Web Table rows/columns into List of Maps
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		List<Map<String, String>> table =
		        rows.stream()
		            .map(row -> {
		                List<WebElement> cells = row.findElements(By.tagName("td"));
		                Map<String, String> map = new HashMap<>();
		                map.put("Name", cells.get(0).getText());
		                map.put("Price", cells.get(1).getText());
		                map.put("Qty", cells.get(2).getText());
		                return map;
		            })
		            .toList();
		
		// Web Table to list of lists (text only)
		List<List<String>> webTable = rows.stream()
		        .map(row -> row.findElements(By.tagName("td")) // columns
		                       .stream()
		                       .map(WebElement::getText)
		                       .toList())
		        .toList();
		
		// Convert each row to map
		List<String> headers = driver.findElements(By.cssSelector("table th"))
                .stream()
                .map(WebElement::getText)
                .toList();

		List<Map<String, String>> table1 = rows.stream()
				.map(row -> {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					Map<String, String> rowMap = new LinkedHashMap<>();

					for (int i = 0; i < headers.size(); i++) {
						rowMap.put(headers.get(i), cells.get(i).getText());
					}
					return rowMap;
				})
			.toList();
		
		// remove empty String values from extracted texts
		List<String> cleaned = texts.stream()
                .filter(t -> !t.isBlank())
                .toList();
		
		// filter only displayed elements
		elements.stream().filter(WebElement::isDisplayed).toList();

		// check everything is visible
		elements.stream().allMatch(WebElement::isDisplayed);
		
		elements.stream()
        .filter(e -> e.getText().equals("Login"))
        .findFirst()   // first element text equals "Login"
        .orElseThrow(); // error handling
		
		// get text only from visible texts
		List<String> onlyVisibleTexts = elements.stream()
                .filter(WebElement::isDisplayed)
                .map(WebElement::getText)
                .toList();
		
		// filter displayed and enabled elements
		List<WebElement> activeElements = elements.stream()
                .filter(WebElement::isDisplayed)
                .filter(WebElement::isEnabled)
                .toList();
		
		// filter elements containing specific texts
		List<WebElement> matches = elements.stream()
                .filter(e -> e.getText().contains("Login"))
                .toList();
		
		// find first element using specific text
		WebElement loginBtn =
		        elements.stream()
		                .filter(e -> e.getText().equalsIgnoreCase("Login"))
		                .findFirst()
		                .orElseThrow(() -> new NoSuchElementException("Login button not found"));
		
		// find element using partial match
		WebElement signUpButton =
		        elements.stream()
		                .filter(e -> e.getText().equalsIgnoreCase("Sign Up"))
		                .findFirst()
		                .orElseThrow(() -> new NoSuchElementException("Sign Up button not found"));
		
		// check all items displayed
		boolean allItemsVisible = elements.stream()
                .allMatch(WebElement::isDisplayed);
		
		// check any item contains error
		boolean hasError = elements.stream()
                .anyMatch(e -> e.getText().contains("Error"));
		
		// check no item contains "404"
		boolean ok = elements.stream()
                .noneMatch(e -> e.getText().contains("404"));
		
		// Assertions
		Assert.assertTrue(
		        elements.stream().allMatch(WebElement::isDisplayed),
		        "Not all elements are visible!"
		);
		
		// check list equality
		List<String> expected = List.of("A", "B", "C");
		List<String> actual = elements.stream().map(WebElement::getText).toList();

		Assert.assertEquals(actual, expected, "Values don't match!");
		
		// explicit wait
		new WebDriverWait(driver, Duration.ofSeconds(10))
	    .until(d -> elements.stream().anyMatch(WebElement::isDisplayed));
		
		
		// Actions class
		WebElement option = elements.stream()
                .filter(e -> e.getText().contains("Buy"))
                .findFirst()
                .orElseThrow();

		new Actions(driver).moveToElement(option).click().perform();
		
		elements.stream().forEach(WebElement::click);
		
		/* Most Useful Streams Snippet:
		 	.map(WebElement::getText)
			.filter(WebElement::isDisplayed)
			.anyMatch(...)
			.allMatch(...)
			.noneMatch(...)
			.distinct()
			.sorted()
			.findFirst()
			.findAny()
			.toList()
		 */
		
	}
}
