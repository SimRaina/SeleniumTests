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
        driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div")).click();

        String desired_month = "Nov 2024";
        String desired_date = "25";



        while (true) {

            String actual_month = driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[1]/div[2]")).getText();
            System.out.println(actual_month);
            if (actual_month.contains(desired_month)) {
                System.out.println(actual_month);
                break;

            } else {
                driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[1]/div[3]")).click(); // next month
            }
        }

        int column_size = 7; // as per the days (Mon - Sun)
        int flag = 0;
        int row_size = driver.findElements(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[3]/div")).size(); // 8
        for(int i = 2; i<=row_size; i++){ // row

            for(int j = 1; j<= column_size; j++){ // column

                String actual_date = driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[3]/div["+i+"]/span/div["+j+"]")).getText();

                if(actual_date.equals(desired_date)){
                    driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[3]/div["+i+"]/span/div["+j+"]")).click();
                    flag = 1; // set flag = 1
                    Thread.sleep(3000);
                    break; // breaking out of inner loop
                }
                else{
                    continue;
                }
            }
            if(flag == 1){ // selection of the date is done
                break;
            }
        }
    }

    @AfterTest
      public void postCondition(){

        closeBrowser();
    } 
}

