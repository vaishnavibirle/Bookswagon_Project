package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp_Page extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='Signup']")
    WebElement signup_button;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtEmail']")
    WebElement input_email;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtPassword']")
    WebElement input_password;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_txtConfirmPwd']")
    WebElement confirm_password;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignUp_btnSubmit']")
    WebElement signup;

    public SignUp_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String signup() throws InterruptedException {
        signup_button.click();
        Thread.sleep(3000);
        input_email.sendKeys("vaishnavibirle2209@gmail.com");
        input_password.sendKeys("Vaishnavi@123");
        confirm_password.sendKeys("Vaishnavi@123");
        Thread.sleep(2000);
        signup.click();
        Thread.sleep(2000);
        return driver.getTitle();
    }
}
