package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener{
	WebDriver driver;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		//System.out.println("Test Getting Started: " + result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String  testMethodName = result.getMethod().getMethodName();
			String path = getScreenshot(driver, testMethodName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
