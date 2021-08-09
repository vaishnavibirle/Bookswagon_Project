package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.Log;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Feature("Home page")
@Description("Working with home and logging out")
@Severity(SeverityLevel.CRITICAL)
@Story("Navigating to url : https://www.bookswagon.com/" +
        "tried adding to cart as well as wishlist" +
        "Also tried for removing from cart")

public class Home_Page extends BaseClass {

    @FindBy(xpath = "//a[@class='sprite home-ico toplevel oneline']")
    WebElement home;

    @FindBy(xpath = "//div[@class='books-category']//a[normalize-space()='Computer & Internet']")
    WebElement computer_nd_internet;

    @FindBy(xpath = "//a[normalize-space()='Applied Data Science Using Pyspark']")
    WebElement book;

    @FindBy(xpath = "//input[@value='Add to Wishlist']")
    WebElement add_to_wishlist;

    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement checkbox;

    @FindBy(xpath = "//span[@class='cart-item-count']")
    WebElement cart;

    @FindBy(xpath = "//a[normalize-space()='Remove']")
    WebElement remove_from_cart;

    @FindBy(xpath = "//span[@class='login-bg sprite usermenu-bg']")
    WebElement myProfile;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logout;

    @FindBy(xpath = "//ul[@class='ac-tabs']//a[normalize-space()='My Addresses']")
    WebElement addresses;

    @FindBy(xpath = "//input[@value='Add a New Address']")
    WebElement add_new;

    @FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_imgSubmit']")
    WebElement save_address;

    public Home_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String add_to_cart() throws InterruptedException {
        Log.info("Clicking on home button");
        home.click();
        Thread.sleep(1000);
        Log.info("Selecting book and clicking");
        computer_nd_internet.click();
        Thread.sleep(1000);
        book.click();
        Thread.sleep(2000);
        Log.info("Added to wishlist");
        add_to_wishlist.click();
        Thread.sleep(4000);
        Log.info("clicked on cart");
        cart.click();
        Thread.sleep(3000);
        Log.info("Click on checked box");
        checkbox.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }

    public String remove_from_cart() throws InterruptedException {
        Log.info("Clicking on cart");
        cart.click();
        Thread.sleep(1000);
        Log.info("Switching to frame");
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        Log.info("removing items from cart");
        remove_from_cart.click();
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        Log.info("Click on closed box");
        checkbox.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }

    public String logout() throws InterruptedException {
        Actions actions = new Actions(driver);
        Log.info("Mouse hovering on my account menu");
        actions.moveToElement(myProfile);
        Thread.sleep(300);
        Log.info("mouse hovering on logout sub menu");
        actions.moveToElement(logout).build().perform();
        Log.info("Clicking on sub menu logout");
        logout.click();
        Log.info("you're logout successfully");
        Thread.sleep(400);
        return driver.getTitle();
    }

    public String adding_address() throws InterruptedException {
        addresses.click();
        Thread.sleep(1000);
        add_new.click();
        Thread.sleep(1000);
        save_address.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        Log.info("Mouse hovering on my account menu");
        actions.moveToElement(myProfile);
        Thread.sleep(300);
        Log.info("mouse hovering on logout sub menu");
        actions.moveToElement(logout).build().perform();
        Log.info("Clicking on sub menu logout");
        logout.click();
        Log.info("you're logout successfully");
        Thread.sleep(400);

        return driver.getTitle();
    }
}
