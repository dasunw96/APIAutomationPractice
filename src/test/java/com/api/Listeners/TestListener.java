package com.api.Listeners;

import com.api.Utilities.ExtentManager;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;


public class TestListener extends ExtentManager implements ITestListener  {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    private static String getTestName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite started!!!");
    }

    public void onFinish(ITestContext context) {
        ExtentManager.endReport();
        logger.info("Test Suite Ended!!!");
    }

    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
            test.log(Status.PASS,"Passed!!!");

    }

    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL,"Failed!!!");
            test.log(Status.FAIL,result.getThrowable().getMessage());
            test.log(Status.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));

    }

    public void onTestSkipped(ITestResult result) {
            test.log(Status.SKIP,"Skipped!!!");;


    }
}
