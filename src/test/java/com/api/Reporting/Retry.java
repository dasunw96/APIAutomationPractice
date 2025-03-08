package com.api.Reporting;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int count = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {

        int maxRetry = 4;

        if (!iTestResult.isSuccess()){
            if (count <= maxRetry){
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
