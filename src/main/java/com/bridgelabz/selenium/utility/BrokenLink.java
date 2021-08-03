package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BrokenLink extends BaseClass {

    @FindBy(tagName = "a")
    List<WebElement> link;

    @FindBy(tagName = "img")
    WebElement image;

    public BrokenLink(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void broken_link() throws IOException {
        List<WebElement> linkList = link;
        linkList.addAll(Collections.singleton(image));

        System.out.println("size of full links and images-->>"+linkList.size());

        List<WebElement> activeLinks = new ArrayList<>();

        for (WebElement webElement : linkList) {
            System.out.println(webElement.getAttribute("href"));
            if (webElement.getAttribute("href") != null) {
                webElement.getAttribute("href");
            }
            {
                activeLinks.add(webElement);
            }
        }

        System.out.println("size of active links and images --->>"+activeLinks.size());

        for (WebElement activeLink : activeLinks) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLink.getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLink.getAttribute("href") + "-->>" + response);
        }
        driver.getCurrentUrl();
    }
}
