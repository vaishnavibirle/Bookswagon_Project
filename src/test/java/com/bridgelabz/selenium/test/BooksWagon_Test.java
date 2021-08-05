package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Home_Page;
import com.bridgelabz.selenium.pages.Login_Page;
import com.bridgelabz.selenium.utility.Log;
import com.bridgelabz.selenium.utility.listeners.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener.class)
public class BooksWagon_Test extends BaseClass {

//    @Test
//    public void signup_test() throws InterruptedException {
//        SignUp_Page signUp_page = new SignUp_Page(driver);
//        signUp_page.signup();
//    }

    @Test()
    public void login_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        String actual = login_page.login_with_credentials();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        System.out.println("Logged in successfully.");
    }


    @Test(priority = 1)
    public void add_to_wishlist_test() throws InterruptedException {
        Home_Page homePage = new Home_Page(driver);
        String actual = homePage.add_to_cart();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        Log.info("Please enter valid credentials");
        System.out.println("Book is added to cart is successfully!!");
    }

    @Test(priority = 2)
    public void remove_book_test() throws InterruptedException {
        Home_Page homePage = new Home_Page(driver);
        String actual_title = homePage.remove_from_cart();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title,expected_title);
        System.out.println("book is removed successfully");
    }

//    @Test
//    public void broken_link_test() throws IOException {
//        BrokenLink brokenLink = new BrokenLink(driver);
//        brokenLink.broken_link();
//    }


}
