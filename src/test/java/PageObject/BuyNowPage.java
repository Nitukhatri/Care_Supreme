package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyNowPage {

	WebDriver Qdriver;

	public BuyNowPage(WebDriver RDriver) {
		Qdriver = RDriver;
		PageFactory.initElements(RDriver, this);
	}
	
	@FindBy(xpath = "//div[@id='custom-handle']")
	public WebElement Slider;
	
	@FindBy(className = "total_premium prem_amount care_premium premium_post_discount")
	public WebElement TotalPremium;
	
}
