package com.api.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.io.File;

    public class ExtentReportListener implements ITestListener {

        private static ExtentReports extent;
        private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

        @Override
        public void onStart(ITestContext context) {
            File reportDir = new File("TestOutput");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            ExtentSparkReporter spark = new ExtentSparkReporter("TestOutput/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Shubham");
        }

        @Override
        public void onTestStart(ITestResult result) {
            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
            test.set(extentTest);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            test.get().pass("Test passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            test.get().fail(result.getThrowable());
        }

        @Override
        public void onFinish(ITestContext context) {
            extent.flush();
            System.out.println("Extent Report generated at: TestOutput/ExtentReport.html");
        }
    }


