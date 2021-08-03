package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Bookswagon_Page;
import com.bridgelabz.selenium.pages.Home_Page;
import com.bridgelabz.selenium.pages.Login_Page;
import com.bridgelabz.selenium.utility.BrokenLink;
import com.bridgelabz.selenium.utility.DataProvider;
import com.bridgelabz.selenium.utility.Log;
import com.bridgelabz.selenium.utility.listeners.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomListener.class)
public class BooksWagon_Test extends BaseClass {

//    @Test
//    public void signup_test() throws InterruptedException {
//        SignUp_Page signUp_page = new SignUp_Page(driver);
//        signUp_page.signup();
//    }

    @Test
    public void login_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        String actual = login_page.login_with_credentials();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Home_Page homePage = new Home_Page(driver);
        homePage.logout();
        Assert.assertEquals(actual,expected);
        System.out.println("Logged in and out successfully.");
    }

    @Test
    public void login_negative_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        String actual_title = login_page.login_with_invalid_credentials();
        String expected_title = "Online Bookstore | Buy Books Online | Read Books Online";
        Assert.assertEquals(actual_title,expected_title);
        Log.info("Please enter valid credentials");
        System.out.println("Invalid email or password");
    }

    @Test
    public void add_to_wishlist_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.login_with_credentials();
        Home_Page homePage = new Home_Page(driver);
        String actual = homePage.add_to_cart();
        String expected = "Online Bookstore | Buy Books Online | Read Books Online";
        Assert.assertEquals(actual,expected);
        Log.info("Please enter valid credentials");
        Home_Page home_page = new Home_Page(driver);
        home_page.logout();
        System.out.println("Book is added to cart is successfully!!");
    }

    @Test
    public void search_book_test() throws InterruptedException {
        Bookswagon_Page bookswagon_page = new Bookswagon_Page(driver);
        String actual = bookswagon_page.add_to_wishlist_books();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        Log.info("Checking title actual and expected");
        System.out.println("Please login first!");
    }

    @Test(dataProvider = "test1",dataProviderClass = DataProvider.class)
    public void buy_book_test(String username,String password,String name,String address,String  pincode,String mobile) throws InterruptedException {
        Bookswagon_Page bookswagon_page = new Bookswagon_Page(driver);
        String act_title = bookswagon_page.buy_test(username,password,name,address,pincode,mobile);
        String exp_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(act_title,exp_title);
        System.out.println("Added shipping address!!");
    }

    @Test
    public void remove_book_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.login_with_credentials();
        Home_Page homePage = new Home_Page(driver);
        String actual_title = homePage.remove_from_cart();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Home_Page home_page = new Home_Page(driver);
        home_page.logout();
        Assert.assertEquals(actual_title,expected_title);
        System.out.println("book is removed successfully");
    }

    @Test
    public void broken_link_test() throws IOException {
        BrokenLink brokenLink = new BrokenLink(driver);
        brokenLink.broken_link();
    }

    @Test
    public void logout_test() throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.login_with_credentials();
        Home_Page homePage = new Home_Page(driver);
        String actual = homePage.logout();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        System.out.println("Logged out successfully.");
    }
}
