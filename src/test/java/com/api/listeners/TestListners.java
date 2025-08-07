package com.api.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;


public class TestListners implements ITestListener {
    private  static  final Logger logger = LogManager.getLogger(TestListners.class);
    public  void onStart(ITestContext context){
         logger.info("Test Suit Started !!");

    }

    public  void onTestSuccess(ITestResult result){
        logger.info("Description !!"+ result.getMethod().getDescription());
        logger.info(result.getMethod().getMethodName() + "Test case PASSED : ");
    }
    public void onTestFailure(ITestResult result) {
        logger.info("Test Suit Started !!"+ result.getMethod().getDescription());
        logger.error("Test case Failed !!" + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test Suit Started !!"+ result.getMethod().getDescription());
        logger.info( "Skipped!! "+ result.getMethod().getMethodName());
    }
    public void onFinish(ITestContext context) {
        logger.info("Test Suit completed !!");
    }
}
