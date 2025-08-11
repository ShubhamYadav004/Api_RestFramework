package com.api.tests;

import com.api.utils.Report.ExtentReport;
import com.api.utils.Email.EmailSender; // ✅ Ensure correct import for email utility
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String reportPath; // ✅ Global so afterSuite can use it

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // ✅ Create TestOutput directory at project root
        String outputDir = System.getProperty("user.dir") + File.separator + "TestOutput";
        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // ✅ Final HTML report path
        reportPath = outputDir + File.separator + "extent-report.html";

        // ✅ Create Extent Report instance
        extent = ExtentReport.createInstance(reportPath);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"testName", "description"})
    public void beforeMethod(@Optional String testName, @Optional String description) {
        ExtentTest extentTest = extent.createTest(
                testName != null ? testName : "Unnamed Test",
                description != null ? description : ""
        );
        test.set(extentTest);
    }

    public ExtentTest getTest() {
        return test.get();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }

        try {
            // Send report via email after flushing
            EmailSender.sendEmailWithAttachments(reportPath);
        } catch (Exception e) {
            System.err.println("❌ Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
