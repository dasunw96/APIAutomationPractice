package com.api.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();
    public static ExtentTest test;

    public synchronized static void createExtentSparkReports(){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Reports/MyReport.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("API automation Practice Project");

        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Reporter","Dasun");

    }

    public static void endReport() {
        extentReports.flush();
    }
}
