package testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import utilities.Screenshot;

public class TestBase {

	public WebDriver driver;
	ExtentReports report;
	public ExtentTest logger;

	@BeforeMethod
	public void initSetup() {

		report = new ExtentReports(
				".\\src\\test\\resources\\Reports\\ExtentReport_" + System.currentTimeMillis() + ".html", true);
		logger = report.startTest("Verify Amazon application end-to-end");

		driver = DataProviderFactory.getBrowserConfig().getBrowser("chrome");
		logger.log(LogStatus.INFO, "Browser launched successfully");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "URL entered and application launched successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			String path = Screenshot.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		driver.close();
		logger.log(LogStatus.INFO, "Browser Instance closed successfully");
		driver.quit();
		logger.log(LogStatus.INFO, "Driver Instance closed successfully");
		report.endTest(logger);
		report.flush();
	}

}
