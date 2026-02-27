package Reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;
import io.appium.java_client.android.AndroidDriver;


public class ItestListeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentreportsNG.configextentreports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);	
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		extentTest.get().log(Status.SKIP, "The Test got skipped");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver =(AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
			String filepath = screenshotfailure(result.getMethod().getMethodName(),BaseTest.driver);
			
			extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	

}
