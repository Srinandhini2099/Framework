package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentaion implements ITestListener {


	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is statred ");
		// TODO Auto-generated method stub
		//Configure the extend report
		ExtentSparkReporter esr =new ExtentSparkReporter(".\\ExtentReports\\Reports");
		
		esr.config().setDocumentTitle("Saw laps Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		ExtentReports report = new ExtentReports();
		 report.attachReporter(esr);
		 report.setSystemInfo("Base Browser", "Microsoft Edge");
		 report.setSystemInfo("Base Platform", "Windows");
		 report.setSystemInfo("Base Env", "Testing");
		 report.setSystemInfo("Reporter name", "Srinandhini");
		
		
		ITestListener.super.onTestStart(result);
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is success");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"->@Test Execution is Failure");
		ITestListener.super.onTestFailure(result);
		
		//capture Screenshot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		String scrennshotName=methodName+"-"+j.getSystemdataInFormate();
		try {
			s.captureScreenshort(BaseClass.sdriver, scrennshotName);
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
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
