package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import testbase.TestBase;

public class TC02_AddProductToTheCart extends TestBase {

	@Test
	public void addProductToTheCartAndValidate() throws InterruptedException {
		Actions action = new Actions(driver);
		HomePage homePage = new HomePage(driver);
				
		action.moveToElement(homePage.signInDrpDwn).build().perform();
		action.moveToElement(homePage.signInBtn).click().build().perform();
	
		homePage.loginToTheAppAndValidate();
		logger.log(LogStatus.INFO, "Logged into the application successfully");
		
		String welcomeText = homePage.getWelcomeText();
		
		System.out.println(homePage.getWelcomeText());
		Assert.assertEquals(welcomeText.contains("Thanuj"), true);
		logger.log(LogStatus.PASS, "Login validated successfully");
		Thread.sleep(2000);
		
		action.moveToElement(homePage.categoryDrpDwn).build().perform();
		Thread.sleep(2000);
		action.moveToElement(homePage.fireTvStickLnk).build().perform();
		Thread.sleep(2000);
		action.moveToElement(homePage.allNewFireTvStick4KLnk).click().build().perform();
		Thread.sleep(3000);
		
		String productText = homePage.getProductText();
		
		System.out.println(productText);
		
		Assert.assertEquals(productText.contains("Fire TV Stick 4K with All-New Alexa Voice Remote"), true);
		
		String prodPriceBeforeAddingToCart = homePage.getProductPrice();
		
		System.out.println(prodPriceBeforeAddingToCart);
		
		homePage.addProdToTheCart();
		
		Thread.sleep(2000);
		
		String cartPageTitle = homePage.getPageTitle();
		System.out.println("Cart Page title is: "+cartPageTitle);
		Assert.assertTrue(cartPageTitle.contains("Shopping Cart"));
		
		String cartSuccessMsg = homePage.getProdAddSuccessMsgText();
		System.out.println("Cart success message is: "+cartSuccessMsg);
		Assert.assertTrue(cartSuccessMsg.contains("item was added to your cart"));
		
		String cartProductPrice = homePage.getCartProdPrice().trim();
		System.out.println("Product price after adding to cart is: "+cartProductPrice);
		Assert.assertEquals(cartProductPrice, prodPriceBeforeAddingToCart);
		
		String subOrderTotalPrice = homePage.getSubOrderTotalPrice().trim();
		System.out.println("Sub Order total cart price is: "+subOrderTotalPrice);
		Assert.assertEquals(subOrderTotalPrice, prodPriceBeforeAddingToCart);
		
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
