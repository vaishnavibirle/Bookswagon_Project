package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.Library;
import com.bridgelabz.selenium.utility.Log;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Feature("Logging into application.")
@Description("Logging with invalid and valid credentials")
@Severity(SeverityLevel.CRITICAL)
@Story("Navigating to url : https://www.bookswagon.com/" +
        "And tried for logging into application using valid" +
        "as well as invalid credentials")

public class Login_Page extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement Login_Btn;

    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement sign_in_email;

    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    WebElement sign_in_pwd;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]")
    WebElement login;


    public Login_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String login_with_credentials() throws InterruptedException {
        Log.info("Clicking on login button");
        Login_Btn.click();
        Thread.sleep(2000);
        Log.info("sending email credential");
        sign_in_email.sendKeys(Library.getProperty(Library.CONFIG_PATH,"username"));
        Thread.sleep(2000);
        Log.info("sending password credentials");
        sign_in_pwd.sendKeys(Library.getProperty(Library.CONFIG_PATH,"password"));
        Thread.sleep(2000);
        Log.info("Clicking on login button");
        login.click();
        Thread.sleep(4000);
        return driver.getTitle();
    }

    public String login_with_invalid_credentials() throws InterruptedException {
        Log.info("Clicking on login button");
        Login_Btn.click();
        Thread.sleep(2000);
        Log.info("Entering invalid details");
        sign_in_email.sendKeys("vaishnavibirle.com");
        Thread.sleep(2000);
        sign_in_pwd.sendKeys("Vaishnavi");
        Thread.sleep(2000);
        Log.info("Clicking on login button");
        login.click();
        Thread.sleep(3000);
        Log.info("Navigating to url");
        driver.navigate().back();
        Thread.sleep(2000);
        return driver.getTitle();
    }
}
