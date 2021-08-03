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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Feature("BooksWagon Page")
@Description("Create methods for implementing operations")
@Story("Created method for adding book to wishlist" +
        "and buying method is letting all address to get into" +
        "textboxes" +
        "returning title")
@Severity(SeverityLevel.NORMAL)

public class Bookswagon_Page extends BaseClass {

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    WebElement search_bar;

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    WebElement search_enter;

    @FindBy(xpath = "//div[@id='listSearchResult']")
    List<WebElement> search_list;

    @FindBy(xpath = "//div[1]//div[4]//div[5]//a[2]//input[1]")
    WebElement add_to_wishlist;

    @FindBy(xpath = "/html/body/form/div[4]/div[2]/div[3]/div[2]/div[2]/div[4]/div[5]/a[1]/input")
    WebElement buy_now;

    @FindBy(name = "BookCart$lvCart$ctrl0$txtQty")
    WebElement quantity;

    @FindBy(name = "BookCart$lvCart$imgPayment")
    WebElement place_order;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_txtEmail']")
    WebElement sign_in_email;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_txtPassword']")
    WebElement sign_in_pwd;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_imgLogin']")
    WebElement login;

    @FindBy(name = "ctl00$cpBody$txtNewRecipientName")
    WebElement recipient_name;

    @FindBy(name = "ctl00$cpBody$txtNewAddress")
    WebElement recipient_address;

    @FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewCountry']//option[@value='India'][normalize-space()='India']")
    WebElement recipient_country;

    @FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewState']//option[@value='Maharashtra'][normalize-space()='Maharashtra']")
    WebElement recipient_state;

    @FindBy(xpath = "//option[@value='Aurangabad']")
    WebElement recipient_city;

    @FindBy(name = "ctl00$cpBody$txtNewPincode")
    WebElement recipient_pincode;

    @FindBy(name = "ctl00$cpBody$txtNewMobile")
    WebElement recipient_mobile;

    @FindBy(name = "ctl00$cpBody$imgSaveNew")
    WebElement submit_details;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_lvCustomerAdd_ctrl0_imgDelete']")
    WebElement remove_address;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
    WebElement save_and_continue;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logout_btn;

    public Bookswagon_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String add_to_wishlist_books() throws InterruptedException {
        Log.info("Clicking on search bar");
        search_bar.click();
        Thread.sleep(1000);
        Log.info("sending book name in search bar");
        search_bar.sendKeys("shyamchi aai");
        Thread.sleep(2000);
        Log.info("Selecting on book");
        search_enter.click();
        Thread.sleep(1000);
        System.out.println(search_list.size());
        Thread.sleep(2000);

        System.out.println(search_list.get(0).getText());
        Thread.sleep(3000);
        search_list.get(0).click();
        Thread.sleep(4000);
        Log.info("Adding book to wishlist");
        add_to_wishlist.click();
        Thread.sleep(5000);
        return driver.getTitle();
    }

    public String buy_test(String username,String password,String name,String address,String pincode,String mobile) throws InterruptedException {
        Log.info("Clicking on search bar");
        search_bar.click();
        Thread.sleep(1000);
        Log.info("Enter book name");
        search_bar.sendKeys("shyamchi aai");
        Thread.sleep(2000);
        search_enter.click();
        Thread.sleep(1000);

        System.out.println(search_list.size());
        Thread.sleep(2000);

        System.out.println("List of books : " + search_list.get(0).getText());
        System.out.println("-----------------------------------------");
        Thread.sleep(3000);
        search_list.get(0).click();
        Thread.sleep(4000);
        Log.info("Clicking on buy now");
        buy_now.click();
        Thread.sleep(3000);
        Log.info("Switching to frame");
        driver.switchTo().frame(0);
        Thread.sleep(500);
        Log.info("Adding quantity of books");
        quantity.clear();
        Thread.sleep(500);
        quantity.sendKeys("2");
        Thread.sleep(1000);
        Log.info("clicking on place order");
        place_order.click();
        Thread.sleep(500);
        Log.info("Switching to parent frame");
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        Log.info("Enter address details");
        sign_in_email.sendKeys(username);
        Thread.sleep(1000);
        sign_in_pwd.sendKeys(password);
        Thread.sleep(1000);
        login.click();
        Thread.sleep(1000);
        remove_address.click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        recipient_name.sendKeys(name);
        Thread.sleep(1000);
        recipient_address.sendKeys(address);
        Thread.sleep(500);
        recipient_country.click();
        Thread.sleep(500);
        recipient_state.click();
        Thread.sleep(500);
        recipient_city.click();
        Thread.sleep(500);
        recipient_pincode.sendKeys(pincode);
        Thread.sleep(500);
        recipient_mobile.sendKeys(mobile);
        Thread.sleep(500);
        submit_details.click();
        Thread.sleep(1500);
        save_and_continue.click();
        Thread.sleep(1000);
        Log.info("Logging out after doing all process");
        logout_btn.click();
        Thread.sleep(1000);
        return driver.getTitle();
    }
}
