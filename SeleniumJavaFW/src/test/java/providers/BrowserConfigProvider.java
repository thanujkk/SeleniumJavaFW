package providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import factory.DataProviderFactory;

public class BrowserConfigProvider {

	WebDriver driver;

	public WebDriver getBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getIePath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		
		return driver;

	}
	

}
