package com.saucedemo.swaglabs.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
      /*  String baseDir = System.getProperty("user.dir");
        String chromeDir= baseDir + "/browser/chromedriver.exe ";

        System.setProperty("webDriver.chrome.driver", chromeDir);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/


        //String firefoxDir = baseDir + "/browser/geckodriver";
        //System.setProperty("webdriver.gecko.driver", firefoxDir);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @BeforeMethod
        public void beforeMethod() {
        driver.navigate().to("http://the-internet.herokuapp.com/");
        //driver.navigate().to("https://www.facebook.com/");
         sleepTest(2000);
        }
    @AfterMethod
    public void afterTest(){
        System.out.println(" ");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();

    }

    public static void sleepTest(long sleeptime){
        try{Thread.sleep(sleeptime);
        } catch (Exception e){

        }
    }

}
