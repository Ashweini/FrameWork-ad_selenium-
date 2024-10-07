package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportsImp implements ITestListener{
	
	ExtentTest test;
	ExtentReports report;

	public void onTestStart(ITestResult result) {//@Test
		test = report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		System.out.println("Script Pass");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
//		System.out.println("Script fail");

		System.out.println("----------im taking ScreenShot-----");
		String screenshot=null;
		try {
			screenshot = WebDriver_Utility.takeScreenShot1(BaseClass.driver, result.getMethod().getMethodName());

		} catch (Throwable e) {

			e.printStackTrace();
		}
	//	test.addScreenCaptureFromPath(screenshot);
	}

	public void onTestSkipped(ITestResult result) {
//		test.log(Status.SKIP, result.getMethod().getMethodName());
//		test.log(Status.SKIP, result.getThrowable());
		System.out.println("Script skipped");
	}

	public void onStart(ITestContext context) {
		JavaUtility jlib = new JavaUtility();
		int ranNum = jlib.getRandomNum();

		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html" + ranNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Ashwini");

		// System configuration
		report = new ExtentReports();

		report.attachReporter(spark);
		report.setSystemInfo("platform", "window11");
		report.setSystemInfo("executedBy", "ASHWINI");
		report.setSystemInfo("Reviewed By", "Shubha Rani");
	}

	public void onFinish(ITestContext context) {
		report.flush();

	}

}
