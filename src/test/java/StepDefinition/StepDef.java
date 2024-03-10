package StepDefinition;

import org.junit.Assert;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import PageObject.MobileToPincode;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDef extends BaseClass {

	
	@Before
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("SetUp method.");
		
		
	}

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		MobToPin = new MobileToPincode(driver);
		driver.manage().window().maximize();
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Mobile number as {string}")
	public void user_enters_mobile_number_as(String mobNumber) {
		MobToPin.EnterMobileno(mobNumber);
	}

	@When("Click on Calculate premium")
	public void click_on_calculate_premium() {
		MobToPin.ClickCalculatePremiumBtn();
	}

	@Then("Section title should be {string}")
	public void section_title_should_be(String ExpectedTitle) {
		String ActualTitle = driver
				.findElement(By.xpath("//div[@class='step2 form-step Cr-PreQuote-InsuredDetails']//h2")).getText();

		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	////////////////// INVAILD MOBILE NUMBER ERROR MESSAGE///////////////////////

	@Then("Error Message should be {string}")
	public void error_message_should_be(String ExpectedError) {

		String ActualError = driver.findElement(By.xpath("//small[@class='error_msg mobile_error']")).getText();

		if (ActualError.contains(ExpectedError)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	////////////////////////// Member selection Validation Relation combination for
	////////////////////////// self


	@When("Select member one {string}")
	public void select_member_one(String Member) {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (Member) {

		case "self": {
			System.out.println("Self already Selected.");
			break;

		}
		case "spouse": {
			MobToPin.SelectSelf();		 				// unselecting default selected Self
			MobToPin.SelectSpouse();
			break;

		}
		case "father": {
			MobToPin.SelectSelf();						// unselecting default selected Self
			MobToPin.SelectFather();
			break;

		}
		case "mother": {
			MobToPin.SelectSelf();						// unselecting default selected Self
			MobToPin.SelectMother();
			break;
		}
		case "father-in-law": {
			MobToPin.SelectSelf();						// unselecting default selected Self
			MobToPin.SelectfatherInLaw();
			break;
		}
		case "mother-in-law": {
			MobToPin.SelectSelf();						// unselecting default selected Self
			MobToPin.SelectMotherInLaw();
			break;
		}
		}

	}

	@When("Select member two {string}")
	public void select_member_two(String Member) {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (Member) {

		case "self": {
			MobToPin.SelectSelf();
			break;

		}
		case "spouse": {
			MobToPin.SelectSpouse();
			break;

		}
		case "father": {
			MobToPin.SelectFather();
			break;

		}
		case "mother": {
			MobToPin.SelectMother();
			break;
		}
		case "father-in-law": {
			MobToPin.SelectfatherInLaw();
			break;
		}
		case "mother-in-law": {
			MobToPin.SelectMotherInLaw();
			break;
		}
		}


		}

	@When("Click on continue button")
	public void click_on_continue_button() {

		MobToPin.ClickContinueBtn();
	}

	@Then("Combination Error message should be {string}")
	public void combination_error_message_should_be(String ExpectedError) {
		String ActualError = driver.findElement(By.xpath("//div[@class='step2 form-step Cr-PreQuote-InsuredDetails']")).getText();
		if (ActualError.contains(ExpectedError)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	
	////////////////// Allowed Relation Cobination
	
	@Then("Age Section title should be {string}")
	public void age_section_title_should_be(String ExpectedTitle) {
	   
		String ActualTitle = driver.findElement(By.xpath("//div[@class='step3 form-step Cr-PreQuote-InsuredAge']")).getText();
		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	//////////////// four member positive scenario
	
	@When("Select member one as {string} member two as {string} member three as {string}")
	public void select_member_one_as_member_two_as_member_three_as(String spouse,String son,String daughter)
	{
		MobToPin.SelectSpouse();
		MobToPin.SelectSon();
		MobToPin.SelectDaughter();
	}

	
	/////////////////// Age Selection
	
	@When("Select self age as {string} spouse age as {string} son age as {string} and daughter age as {string}")
	public void select_self_age_as_spouse_age_as_son_age_as_and_daughter_age_as(String age1, String age2, String age3, String age4) {
		
		MobToPin.SelectSelfAge(age1);
		MobToPin.SelectSpouseAge(age2);
		MobToPin.SelectSonAge(age3);
		MobToPin.SelectDaughterAge(age4);
	}

	@When("Click on age countinue button")
	public void click_on_age_countinue_button() {
		MobToPin.ClickAgeContinuebtn();
	}

	@Then("Pincode Section title should be {string}")
	public void pincode_section_title_should_be(String ExpectedTitle) {
		
		String ActualTitle = driver.findElement(By.xpath("//div[@class='step4 form-step Cr-PreQuote-City']")).getText();
		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}


	//////////////////////////////	 	Pincode		 /////////////////
	
	@When("Enter pincode")
	public void enter_pincode() {
	  MobToPin.EnterPincode("124001");
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@When("Enter View Quote button")
	public void enter_view_quote_button() {
		
		
	//	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MobToPin.ViewQuoteBtn));
		
		MobToPin.ClickViewQuoteBtn();
	}

	@Then("Buy Now page will open and title should be {string}")
	public void buy_now_page_will_open_and_title_should_be(String ExpectedTitle) {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body//header//h2[@class='popup_heading']"))));
		
		String ActualTitle = driver.findElement(By.xpath("//body//header//h2[@class='popup_heading']")).getText();
		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	
}

