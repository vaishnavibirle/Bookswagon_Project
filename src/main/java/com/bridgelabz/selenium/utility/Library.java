package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

public class Library extends BaseClass {

    public static String CONFIG_PATH = "config/config.properties";

    public static String getProperty(String CONFIG_PATH , String key){
        String property = "";
        Properties obj = new Properties();
        try {
            obj.load(new FileInputStream(CONFIG_PATH));
            property = obj.getProperty(key);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return property;
    }
}
