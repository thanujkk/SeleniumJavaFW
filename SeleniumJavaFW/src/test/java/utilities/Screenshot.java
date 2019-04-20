package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	
	public static String captureScreenshot(WebDriver driver, String screenShotName) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\Thapna\\git\\repository\\SeleniumJavaFW\\src\\test\\resources\\Screenshots\\"+screenShotName+System.currentTimeMillis()+".png";
		File dest = new File(destination);
		
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destination;
	}
		

}
