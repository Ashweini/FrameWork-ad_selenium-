package GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.protobuf.ByteString.Output;

public class ListenerImplementation implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts  = (TakesScreenshot)BaseClass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./FailedScripts.png");
		
		try {
			FileUtils.copyFile(src, dst);	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
