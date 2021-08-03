package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Description("Created Class for capturing screenshot")
@Story("Created Class for capturing screenshot" +
        "Provided file , and used exceptio" +
        "Also given simpleDateFormat")

public class CaptureScreenshot extends BaseClass {

    public void captureScreenshot(String screenshotName, String result) throws IOException {
        String date = new SimpleDateFormat("yyyy_MM_dd_hhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".\\screenshot\\"+result+"\\"+ screenshotName+"_"+date+".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
