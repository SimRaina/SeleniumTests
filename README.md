Few Interview Questions:
Q) How do you handle alerts, popups, and iframes?
Alerts: Alert alert = driver.switchTo().alert();
alert.accept();
alert.dismiss();
String text = alert.getText();

Iframe: driver.switchTo().frame("frame1");
driver.findElement(...);
driver.switchTo().defaultContent();

Browser Popup/New Window
String parent = driver.getWindowHandle();
for(String window : driver.getWindowHandles()){
    driver.switchTo().window(window);
}

Q) Different waits in Selenium – when to use implicit, explicit, or fluent waits
Implicit Wait:
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

Applies globally.

Explicit Wait:
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));

Fluent Wait:
FluentWait<WebDriver> wait =
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(20))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchElementException.class);

Used for highly dynamic elements.

Interview Answer
"Explicit wait is my primary choice because it waits for specific conditions and avoids unnecessary delays."


