package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentaion implements ITestListener {
	ExtentTest test ;
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is statred ");
		// TODO Auto-generated method stub
		
		//Intimate Extent report for test
		 test = report.createTest(methodName);
			
		
		ITestListener.super.onTestStart(result);
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is success");
		ITestListener.super.onTestSuccess(result);
		
		
		////Log the Test result as PASS in Extent Report
		test.log(Status.PASS, methodName + " -> @Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is Failure");
		ITestListener.super.onTestFailure(result);
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodName+"->@Test Execution is Failure");
		
		// Log the exception that caused the failure
	    test.fail(result.getThrowable());  // <== Important
		
		//capture Screenshot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		String scrennshotName=methodName+"-"+j.getSystemdataInFormate();
		try {
			String path = s.captureScreenshort(BaseClass.sdriver, scrennshotName);
			//Attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is Skiped ");
		System.out.println(result.getThrowable());
		ITestListener.super.onTestSkipped(result);
		//Log the status as skip in extent report
		test.log(Status.SKIP, methodName+"->@Test Execution is Failure");
				
	  	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is statred ");
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suit execution started");
		//Configure the extend report
	ExtentSparkReporter esr =new ExtentSparkReporter(".\\ExtentReports\\Report -"+new JavaUtility().getSystemdataInFormate()+".html");
				
				esr.config().setDocumentTitle("Saw laps Execution report");
				esr.config().setReportName("Execution Report");
				esr.config().setTheme(Theme.DARK);
				
				 report = new ExtentReports();
				 report.attachReporter(esr);
				 report.setSystemInfo("Base Browser", "Microsoft Edge");
				 report.setSystemInfo("Base Platform", "Windows");
				 report.setSystemInfo("Base Env", "Testing");
				 report.setSystemInfo("Reporter name", "Srinandhini");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		report.flush();
	}
	
	

}
