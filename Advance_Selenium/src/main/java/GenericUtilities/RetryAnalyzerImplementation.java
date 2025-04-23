package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count =0;
		int retrycount=3;//Manual Analisis
		while(count<retrycount)
		{
			return true;	
		}
		return false;//means it will stop retry 
	}

}
