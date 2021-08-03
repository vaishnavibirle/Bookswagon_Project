package com.bridgelabz.selenium.utility.listeners;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.CaptureScreenshot;
import com.bridgelabz.selenium.utility.Log;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Description("Created CustomListener class")
@Story("Implemented ITestListener interface" +
        "called methods on success , on failure" +
        "on start , on finish,etc")

public class CustomListener extends BaseClass implements ITestListener {

    CaptureScreenshot captureScreenshot = new CaptureScreenshot();

    //onTestFailure method is used when test is failed it will take screenshot automatically
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed " + result.getName());
        try {
            captureScreenshot.captureScreenshot(result.getName(), "failed");
            Log.warn("Test is failed" );
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.warn(result.getName() + "Test is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.debug(result.getName() + "Test is failing but within some success percentage");


    }



    @Override
    public void onStart(ITestContext context) {


    }

    @Override
    public void onFinish(ITestContext context) {

        Log.info(context.getName() + "Test is finished");

    }


    public void onTestStart(ITestResult result) {
        Log.info(result.getName() + "Test is starting");

    }

    //onTestSuccess method is used when test is passed it will take screenshot automatically
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed " + result.getName());
        try {
            captureScreenshot.captureScreenshot(result.getName(), "success");
            Log.info("Test is passed" );
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
