package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {
    @Test
    public void login_facebook(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("xyz@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("xyz");
        driver.findElement(By.id("loginbutton")).click();
    }
}
