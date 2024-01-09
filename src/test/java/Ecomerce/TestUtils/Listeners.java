package Ecomerce.TestUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MobileAutomation.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class Listeners extends BaseTest implements ITestListener{

	  ExtentTest test;
	  
	  ExtentReports extent = ExtentReport.configuration();
	  
	  @Override
	  public void onTestStart(ITestResult result) 
	  {
	  test = extent.createTest(result.getMethod().getMethodName());
	  }
	
	  @Override
	  public  void onTestSuccess(ITestResult result) 
	  {
	   test.log(Status.PASS, "Test Passed");
	   
	  }

	  @Override
	  public void onTestFailure(ITestResult result) {
	   test.fail(result.getThrowable());
	   try {
		   driver =(AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	       }
	   catch(Exception el)
	   {
		   el.printStackTrace();
	   }
	   
	   try {//used to send screen shot to extent report
		   test.addScreenCaptureFromPath(GetScreenShotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	  }

	  @Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  @Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  @Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  @Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	  @Override
	  public void onFinish(ITestContext context) {
	   extent.flush();
	  }
}
