package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Bookswagon_Page;
import com.bridgelabz.selenium.utility.DataProvider;
import com.bridgelabz.selenium.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksWagon_System_Test extends BaseClass {

    @Test
    public void search_book_test() throws InterruptedException {
        Bookswagon_Page bookswagon_page = new Bookswagon_Page(driver);
        String actual = bookswagon_page.add_to_wishlist_books();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        Log.info("Checking title actual and expected");
        System.out.println("Please login first!");
    }

    @Test(dataProvider = "test1",dataProviderClass = DataProvider.class,priority = 1)
    public void buy_book_test(String username,String password,String name,String address,String  pincode,String mobile) throws InterruptedException {
        Bookswagon_Page bookswagon_page = new Bookswagon_Page(driver);
        String act_title = bookswagon_page.buy_test(username,password,name,address,pincode,mobile);
        String exp_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(act_title,exp_title);
        System.out.println("Added shipping address!!");
    }

}
