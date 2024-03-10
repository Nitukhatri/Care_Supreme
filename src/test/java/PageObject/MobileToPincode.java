package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MobileToPincode {

	WebDriver Qdriver;

	public MobileToPincode(WebDriver RDriver) {
		Qdriver = RDriver;
		PageFactory.initElements(RDriver, this);
	}

	@FindBy(id = "mobile_no")
	WebElement Mobileno;

	@FindBy(xpath = "//button[@class='btn_sticky_mobile btn_custom quote_btn custum_common_btn']")
	WebElement CalculatePremium;

	public void EnterMobileno(String number) {
		Mobileno.sendKeys(number);
	}

	public void ClickCalculatePremiumBtn() {
		CalculatePremium.click();
	}

//////////////////For Member Selection

	@FindBy(xpath = "//label[@for='self']")
	WebElement Self;

	@FindBy(xpath = "//label[@for='spouse']")
	WebElement Spouse;

	@FindBy(xpath = "//label[@for='son']")
	WebElement Son;

	@FindBy(xpath = "//label[@for='daughter']")
	WebElement Daughter;

	@FindBy(xpath = "//label[@for='father']")
	WebElement Father;

	@FindBy(xpath = "//label[@for='mother']")
	WebElement Mother;

	@FindBy(xpath = "//label[@for='father-in-law']")
	WebElement FatherInLaw;

	@FindBy(xpath = "//label[@for='mother-in-law']")
	WebElement MotherInLaw;

	@FindBy(xpath = "//button[@class='btn_sticky_mobile btn_custom step2_continue custum_common_btn']")
	WebElement ContinueBtn;

	public void SelectSelf() {
			Self.click();
	}

	public void SelectSpouse() {
		Spouse.click();
	}

	public void SelectSon() {
		Son.click();
	}

	public void SelectDaughter() {
		Daughter.click();
	}

	public void SelectFather() {
		Father.click();
	}

	public void SelectMother() {
		Mother.click();
	}

	public void SelectfatherInLaw() {
		FatherInLaw.click();
	}

	public void SelectMotherInLaw() {
		MotherInLaw.click();
	}

	public void ClickContinueBtn() {
		ContinueBtn.click();

	}
	
	////////////////////// Age Selection
	
	@FindBy(xpath = "//select[@id='self']")
	WebElement SelfAge;

	@FindBy(xpath = "//select[@id='spouse']")
	WebElement SpouseAge;
	
	@FindBy(xpath = "//select[@id='son']")
	WebElement SonAge;
	
	@FindBy(xpath = "//select[@id='daughter']")
	WebElement DaughterAge;
	
	@FindBy(xpath = "//button[@class='btn_sticky_mobile btn_custom step3_continue custum_common_btn']")
	WebElement AgeContinuebtn;
	
	public void SelectSelfAge(String age)
	{
		new Select(SelfAge).selectByValue(age);
	}
	
	public void SelectSpouseAge(String age)
	{
		new Select(SpouseAge).selectByValue(age);
	}

	public void SelectSonAge(String age)
	{
		new Select(SonAge).selectByValue(age);
	}

	public void SelectDaughterAge(String age)
	{
		new Select(DaughterAge).selectByValue(age);
	}
	
	public void ClickAgeContinuebtn() {
		AgeContinuebtn.click();
	}

	
	/////////////////////Pincode //////////////////////////
	
	@FindBy(id="pincode_search")
	WebElement Pincode;
	
	@FindBy(xpath = "//button[@class='btn_sticky_mobile btn_custom view_quote custum_common_btn']")
	public WebElement ViewQuoteBtn;
	
	public void EnterPincode(String pincode) {
		Pincode.sendKeys(pincode);
	}
	
	public void ClickViewQuoteBtn() {
		ViewQuoteBtn.click();
	}
	
}
