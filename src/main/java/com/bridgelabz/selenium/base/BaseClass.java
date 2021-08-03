package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.utility.EmailReport;
import com.bridgelabz.selenium.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class BaseClass {

    public static WebDriver driver;
    URL url;
    URLConnection connection;

    @BeforeTest
    @Feature("BrowserName and url for starting test")
    @Description("Used setUp method for setting the browser")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Navigating to url : https://www.bookswagon.com/")
    public void setUp() throws InterruptedException {
        Log.info("Setting up the chrome browser");
        WebDriverManager.chromedriver().setup();
        Log.info("launching chrome driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        try {
            url = new URL("https://www.bookswagon.com/");
            connection = url.openConnection();
            connection.connect();
            Log.info("Internet is connected");
            Log.info("Navigate to url : https://www.bookswagon.com/ ");
            driver.get("https://www.bookswagon.com/");
            Log.info("maximizing the browser window");
            driver.manage().window().maximize();
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
            Log.info("Internet is not connected");
        }
    }

    @AfterTest
    @Feature("Closing application")
    @Description("Used tearDown method for closing the browser.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Closing the browser.")
    public void tearDown() {
        Log.info("Sending report on email");
        EmailReport.sendMail();
        Log.info("closing the browser after test is completed.");
        driver.quit();
    }
}

