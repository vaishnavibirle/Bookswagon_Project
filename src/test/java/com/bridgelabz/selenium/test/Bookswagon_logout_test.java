package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Home_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bookswagon_logout_test extends BaseClass {

    @Test
    public void logout_test() throws InterruptedException {
        Home_Page homePage = new Home_Page(driver);
        String actual = homePage.logout();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        System.out.println("Logged out successfully.");
    }
}
