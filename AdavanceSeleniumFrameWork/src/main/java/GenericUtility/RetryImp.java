package GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer{

	int count =0;
	int reTrylimit = 3;
	public boolean retry(ITestResult result) {
		if(count<reTrylimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
