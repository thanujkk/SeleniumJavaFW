package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import testbase.TestBase;
import utilities.Screenshot;

public class TC03_DeleteItemFromCart extends TestBase {

	
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
		homePage.deleteCartItem();
		logger.log(LogStatus.INFO, "Item deleted from the cart successfully");
		Thread.sleep(3000);
		String deleteConfirmationText = homePage.getDeleteConfirmText();
		System.out.println(deleteConfirmationText);
		Assert.assertTrue(deleteConfirmationText.contains("removed from Shopping Cart"));
		logger.log(LogStatus.PASS, "Item removal validated successfully");
		
		action.moveToElement(homePage.myAccountDrpDwn).build().perform();
		homePage.clickOnLogOut();
		logger.log(LogStatus.INFO, "Logged out of the application successfully");
		String loginTxtAfterLogOut=homePage.getLoginTextAfterLogout();
		//Assert.assertEquals(loginTxtAfterLogOut, "Login");
		//logger.log(LogStatus.PASS, "Logged out validated successfully");
		Assert.assertEquals(loginTxtAfterLogOut, "LogOut");
		logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshot.captureScreenshot(driver, "Logout_Validation_Failed")));
		System.out.println("Logout successful with confirmation text displayed: "+loginTxtAfterLogOut);
		Thread.sleep(2000);
		
	}

}
