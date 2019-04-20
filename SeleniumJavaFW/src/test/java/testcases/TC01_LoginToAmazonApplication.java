package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import testbase.TestBase;

public class TC01_LoginToAmazonApplication extends TestBase {

	
	@Test
	public void loginToAmazonDotInApp() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);

		Actions action = new Actions(driver);
		action.moveToElement(homePage.signInDrpDwn).build().perform();
		action.moveToElement(homePage.signInBtn).click().build().perform();
			
		homePage.loginToTheAppAndValidate();
		logger.log(LogStatus.INFO, "Logged into the application successfully");
		
		String welcomeText = homePage.getWelcomeText();
		System.out.println("Login successful with confirmation text displayed: "+welcomeText);
		Assert.assertEquals(welcomeText.contains("Thanuj"), true);
		logger.log(LogStatus.PASS, "Login validated successfully");
		
		action.moveToElement(homePage.myAccountDrpDwn).build().perform();
		homePage.clickOnLogOut();
		logger.log(LogStatus.INFO, "Logged out of the application successfully");
		String loginTxtAfterLogOut=homePage.getLoginTextAfterLogout();
		Assert.assertEquals(loginTxtAfterLogOut, "Login");
		logger.log(LogStatus.PASS, "Logged out validated successfully");
		System.out.println("Logout successful with confirmation text displayed: "+loginTxtAfterLogOut);
		Thread.sleep(2000);
		
	}

}
