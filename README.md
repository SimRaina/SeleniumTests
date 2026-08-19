# Selenium Tests

This project is a Maven-based UI automation test suite written in Java. It uses
Selenium WebDriver to interact with web applications and TestNG to organize and
execute tests.

## Technologies

- Java 11
- Selenium WebDriver 4.38.0
- TestNG 7.6.1
- Maven

## Test Coverage

The tests demonstrate and validate common Selenium WebDriver features:

- Browser launch, navigation, closing, and quitting
- Chrome and Firefox browser testing
- Element locators, CSS selectors, XPath, chained locators, and combined locators
- Alerts and browser dialogs
- Cookies
- Dropdowns and multi-select dropdowns
- Date pickers and web tables
- Frames and window handles
- Mouse actions and keyboard interactions
- JavaScript execution
- Implicit, explicit, and fluent waits
- Conditional tests and driver management
- Counting active links

The `JavaStreamsUITests` package also contains UI tests that use Java Streams for
product filtering, product sorting, and counting active links. Both standard and
optimized stream-based examples are included.

## Project Structure

```text
src/test/java/com/seleniumtests/
├── SeleniumTests/       Selenium WebDriver feature tests
└── JavaStreamsUITests/  UI tests using Java Streams
```

## Running the Tests

Run the complete test suite from the project root:

```bash
mvn test
```

Clean previous build output and run the tests:

```bash
mvn clean test
```

Test reports are generated in the `target/surefire-reports` directory when the
Maven test run completes.


