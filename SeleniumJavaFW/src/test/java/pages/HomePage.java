package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DataProviderFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	//@FindBy(css="span:contains(text='Hello, Sign in')")
	public WebElement  signInDrpDwn;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]")
	//@FindBy(css="#nav-flyout-ya-signin .nav-action-inner span:contains(text='Sign in')")
	public WebElement signInBtn;
	
	@FindBy(css="#ap_email") 	public WebElement unameTxtBox;
	
	@FindBy(css="#continue") 	public WebElement continueBtn;
	
	@FindBy(css="#ap_password") 	public WebElement passwordTxtBox;
	
	@FindBy(css="#signInSubmit") 	public WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'Hello, Thanuj')]") public WebElement myAccountDrpDwn;
	//@FindBy(css="span:contains(text='Hello, Thanuj')") public WebElement myAccountDrpDwn;
	
	@FindBy(xpath="//span[contains(text(),'Category')]") public WebElement categoryDrpDwn;
	//@FindBy(css="span:contains(text='Category')") public WebElement categoryDrpDwn;
	
	@FindBy(xpath="//span[contains(text(),'Fire TV Stick')]")
	//@FindBy(css="span:contains(text='Fire TV Stick')")
	public WebElement fireTvStickLnk;
	
	@FindBy(xpath="//span[contains(text(),'All-New Fire TV Stick 4K')]") public WebElement allNewFireTvStick4KLnk;
	//@FindBy(css="span:contains(text='All-New Fire TV Stick 4K')") public WebElement allNewFireTvStick4KLnk;
	
	@FindBy(css="#productTitle") WebElement productTitle;
	 
	@FindBy(css="#priceblock_ourprice") WebElement productPrice;
	
	@FindBy(css="#add-to-cart-button") WebElement addToCardBtn;
	
	@FindBy(xpath="//span[contains(text(),'1 item was added to your cart')]") WebElement prodAddSuccessTxt;
	//@FindBy(css="span:contains(text='1 item was added to your cart')") WebElement prodAddSuccessTxt;
	
	@FindBy(xpath="//div[@class='hlb-price']//span[contains(text(),'5,999.00')]") WebElement cartProductPrice;
	//@FindBy(css=".hlb-price span:contains(text='5,999.00')") WebElement cartProductPrice;
	
	@FindBy(xpath="//span[@class='hlb-price']//span[contains(text(),'5,999.00')]") WebElement subOrderProductPrice;
	//@FindBy(css=".hlb-price span:contains(text='5,999.00')") WebElement subOrderProductPrice;
	
	@FindBy(xpath="//span[contains(text(),'Sign Out')]") WebElement signOutLink;
	
	@FindBy(xpath="//h1[@class='a-spacing-small']") WebElement loginTxt;
	
	@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']") WebElement cartLink;
	
	@FindBy(xpath="//div[@class='a-column a-span8']//input[@value='Delete']") WebElement deleteItem;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']//div[@data-action='delete']/span") WebElement deleteConfirmTxt;
	
	
	
	public HomePage(WebDriver driver){
		this.ldriver=driver;
		
		PageFactory.initElements(ldriver, this);
	}
		
	public void loginToTheAppAndValidate() {
		unameTxtBox.sendKeys(DataProviderFactory.getExcel().getCellData("Login", 1, 0));
		continueBtn.click();
		passwordTxtBox.sendKeys(DataProviderFactory.getExcel().getCellData("Login", 1, 1));
		loginBtn.click();
		
	}
	
	public String getWelcomeText() {
		String welcomeText = myAccountDrpDwn.getText();
		return welcomeText;
	}
	
	public String getProductText() {
		String productText = productTitle.getText();
		return productText;
	}
	
	public String getProdAddSuccessMsgText() {
		String addSuccessMsgText = prodAddSuccessTxt.getText();
		return addSuccessMsgText;
	}
	
	public String getProductPrice() {
		String prodPrice = productPrice.getText().trim();
		return prodPrice;
	}
	
	public void addProdToTheCart() {
		addToCardBtn.click();
	}
	
	public String getPageTitle() {
		String pageTitle = ldriver.getTitle();
		return pageTitle;
	}
	
	public String getCartProdPrice() {
		String cartProdPrice = cartProductPrice.getText();
		String finalCartProdPrice = cartProdPrice.trim();
		return finalCartProdPrice;
	}
	
	public String getSubOrderTotalPrice() {
		String subOrderProdPrice = subOrderProductPrice.getText();
		String finalSubOrderProdPrice = subOrderProdPrice.trim();
		return finalSubOrderProdPrice;
	}
	
	public void clickOnLogOut() {
		signOutLink.click();
		
	}
	
	public String getLoginTextAfterLogout() {
		String loginText = loginTxt.getText();
		return loginText;
	}
	
	public void deleteCartItem() {
		cartLink.click();
		deleteItem.click();
	}
	
	public String getDeleteConfirmText() {
		String deleteConfirmText = deleteConfirmTxt.getText();
		return deleteConfirmText;
	}
}
