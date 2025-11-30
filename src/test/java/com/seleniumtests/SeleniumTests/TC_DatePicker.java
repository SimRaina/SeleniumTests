package com.seleniumtests.SeleniumTests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TC_DatePicker extends BaseClass {

    static String browser = "chrome";
    static String url = "https://www.redbus.in/";

    @BeforeTest
    public static void preCondition(){

        init(browser, url);
    }

    @Test
    public static void testDatePicker() throws InterruptedException {
        String desired_month = "December 2025";
        String desired_date = "20";
        //Open date picker
        driver.findElement(By.xpath("//*[text()='Date of Journey']/following-sibling::span")).click();

        while (true) {
        	//Get selected month
            String actual_month = driver.findElement(By.xpath("//p[contains(@class,'monthYear')]")).getText();
            if (actual_month.contains(desired_month)) {
                System.out.println(actual_month);
                break;

            } else {
            	//Click on next month arrow button
                driver.findElement(By.xpath("//i[contains(@aria-label, 'Next month')]")).click(); // next month
            }
        }

        int column_size = driver.findElements(By.xpath("//ul[contains(@class, 'datesWrap')]/li")).size();
            for(int j = 1; j<= column_size; j++){ // column
                String actual_date = driver.findElement(By.xpath("//ul[contains(@class, 'datesWrap')]/li["+j+"]")).getText();
                if(actual_date.equals(desired_date)){
                    driver.findElement(By.xpath("//ul[contains(@class, 'datesWrap')]/li["+j+"]")).click();
                    break;
                }
                else{
                    continue;
                }
            }
    }

    @AfterTest
      public void postCondition(){

        closeBrowser();
    } 
}

