package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void initialize_driver(String browser){
        if(browser.equals("firefox")){
            // create firefox driver instance
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
