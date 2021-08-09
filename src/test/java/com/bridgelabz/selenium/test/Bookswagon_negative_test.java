package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Home_Page;
import com.bridgelabz.selenium.pages.Login_Page;
import com.bridgelabz.selenium.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bookswagon_negative_test extends BaseClass {

    @Test
    public void login_negative_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        String actual_title = login_page.login_with_invalid_credentials();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title,expected_title);
        Log.info("Please enter valid credentials");
        System.out.println("Invalid email or password");
    }

    @Test
    public void address_blank_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.login_with_credentials();
        Home_Page homePage = new Home_Page(driver);
        String actual_title = homePage.adding_address();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title,expected_title);
        Log.warn("required fields can't be kept empty.");
    }
}
