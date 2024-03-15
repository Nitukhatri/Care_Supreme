package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import PageObject.BuyNowPage;
import PageObject.MobileToPincode;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {

	@Before
	public void setup() {
		

	readConfig = new ReadConfig();
		
		//initialise logger
		log = LogManager.getLogger("StepDef");

	//	System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
		
		MobToPin = new MobileToPincode(driver);
		BnP = new BuyNowPage(driver);
		
		log.info("SetUp Execution...");
	

	}

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
		driver.manage().window().maximize();
		
		log.info("user launch chrome browser.");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("User opens URL");
	}

	@When("User enters Mobile number as {string}")
	public void user_enters_mobile_number_as(String mobNumber) {
		MobToPin.EnterMobileno(mobNumber);
		
		log.info("User enters Mobile number.");
	}

	@When("Click on Calculate premium")
	public void click_on_calculate_premium() {
		MobToPin.ClickCalculatePremiumBtn();
		
		log.info("Click on Calculate premium.");
	}

	@Then("Section title should be {string}")
	public void section_title_should_be(String ExpectedTitle) {
		String ActualTitle = driver
				.findElement(By.xpath("//div[@class='step2 form-step Cr-PreQuote-InsuredDetails']//h2")).getText();

		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
			log.warn("Title matched.");
		} else {
			Assert.assertTrue(false);
			log.warn("Title not matched.");
		}
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
		
		log.info("close browser.");
	}

	////////////////// INVAILD MOBILE NUMBER ERROR MESSAGE///////////////////////

	@Then("Error Message should be {string}")
	public void error_message_should_be(String ExpectedError) {

		String ActualError = driver.findElement(By.xpath("//small[@class='error_msg mobile_error']")).getText();

		if (ActualError.contains(ExpectedError)) {
			Assert.assertTrue(true);
			log.warn("Error Message matched.");
		} else {
			Assert.assertTrue(false);
			log.warn("Error Message not matched.");
		}
	}

	////////////////////////// Member selection Validation Relation combination for
	////////////////////////// self

	@When("Select member one {string}")
	public void select_member_one(String Member) {

		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (Member) {

		case "self": {
			System.out.println("Self already Selected.");
			log.info("Select member one as Self");
			break;

		}
		case "spouse": {
			MobToPin.SelectSelf(); // unselecting default selected Self
			MobToPin.SelectSpouse();
			log.info("Select member one as spouse");
			break;

		}
		case "father": {
			MobToPin.SelectSelf(); // unselecting default selected Self
			MobToPin.SelectFather();
			log.info("Select member one as father");
			break;

		}
		case "mother": {
			MobToPin.SelectSelf(); // unselecting default selected Self
			MobToPin.SelectMother();
			log.info("Select member one as mother");
			break;
		}
		case "father-in-law": {
			MobToPin.SelectSelf(); // unselecting default selected Self
			MobToPin.SelectfatherInLaw();
			log.info("Select member one as father-in-law");
			break;
		}
		case "mother-in-law": {
			MobToPin.SelectSelf(); // unselecting default selected Self
			MobToPin.SelectMotherInLaw();
			log.info("Select member one as mother-in-law");
			break;
		}
		}

		
	}

	@When("Select member two {string}")
	public void select_member_two(String Member) {

		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (Member) {

		case "self": {
			MobToPin.SelectSelf();
			log.info("Select member one as Self");
			break;

		}
		case "spouse": {
			MobToPin.SelectSpouse();
			log.info("Select member one as spouse");
			break;

		}
		case "father": {
			MobToPin.SelectFather();
			log.info("Select member one as father");
			break;

		}
		case "mother": {
			MobToPin.SelectMother();
			log.info("Select member one as mother");
			break;
		}
		case "father-in-law": {
			MobToPin.SelectfatherInLaw();
			log.info("Select member one as father-in-law");
			break;
		}
		case "mother-in-law": {
			MobToPin.SelectMotherInLaw();
			log.info("Select member one as mother-in-law");
			break;
		}
		}

	}

	@When("Click on continue button")
	public void click_on_continue_button() {

		MobToPin.ClickContinueBtn();
		
		log.info("Click on continue button");
	}

	@Then("Combination Error message should be {string}")
	public void combination_error_message_should_be(String ExpectedError) {
		String ActualError = driver.findElement(By.xpath("//div[@class='step2 form-step Cr-PreQuote-InsuredDetails']"))
				.getText();
		if (ActualError.contains(ExpectedError)) {
			Assert.assertTrue(true);
			log.warn("Combination Error message matched.");
		} else {
			Assert.assertTrue(false);
			log.warn("Combination Error message not matched.");
		}
	}

	////////////////// Allowed Relation Cobination

	@Then("Age Section title should be {string}")
	public void age_section_title_should_be(String ExpectedTitle) {

		String ActualTitle = driver.findElement(By.xpath("//div[@class='step3 form-step Cr-PreQuote-InsuredAge']"))
				.getText();
		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
			log.warn("Age Section title matched.");
		} else {
			Assert.assertTrue(false);
			log.warn("Age Section title not matched.");
		}
	}
	//////////////// four member positive scenario

	@When("Select member one as {string} member two as {string} member three as {string}")
	public void select_member_one_as_member_two_as_member_three_as(String spouse, String son, String daughter) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		MobToPin.SelectSpouse();
		MobToPin.SelectSon();
		MobToPin.SelectDaughter();
		
		log.info("Select members for family policy");
	}

	/////////////////// Age Selection

	@When("Select self age as {string} spouse age as {string} son age as {string} and daughter age as {string}")
	public void select_self_age_as_spouse_age_as_son_age_as_and_daughter_age_as(String age1, String age2, String age3,
			String age4) {

		MobToPin.SelectSelfAge(age1);
		MobToPin.SelectSpouseAge(age2);
		MobToPin.SelectSonAge(age3);
		MobToPin.SelectDaughterAge(age4);
		
		log.info("Select members age.");
	}

	@When("Click on age countinue button")
	public void click_on_age_countinue_button() {
		MobToPin.ClickAgeContinuebtn();
		
		log.info("Click on age countinue button.");
	}

	@Then("Pincode Section title should be {string}")
	public void pincode_section_title_should_be(String ExpectedTitle) {

		String ActualTitle = driver.findElement(By.xpath("//div[@class='step4 form-step Cr-PreQuote-City']")).getText();
		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
			log.warn("Pincode Section title matched.");
		} else {
			Assert.assertTrue(false);
			log.warn("Pincode Section title not matched.");
		}
	}

	////////////////////////////// Pincode /////////////////

	@When("Enter pincode")
	public void enter_pincode() {
		MobToPin.EnterPincode("124001");
		/*
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		log.info("Enter Pincode.");
	}

	@When("Enter View Quote button")
	public void enter_view_quote_button() {

		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.elementToBeClickable(MobToPin.ViewQuoteBtn));

		MobToPin.ClickViewQuoteBtn();
		
		log.info("Enter View Quote button.");
	}

	@Then("Buy Now page will open and title should be {string}")
	public void buy_now_page_will_open_and_title_should_be(String ExpectedTitle) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//body//header//h2[@class='popup_heading']"))));

		String ActualTitle = driver.findElement(By.xpath("//body//header//h2[@class='popup_heading']")).getText();
		if (ActualTitle.contains(ExpectedTitle)) {
			Assert.assertTrue(true);
			log.warn("Buy Now page will open and title matched.");
		} else {
			Assert.assertTrue(false);
			log.warn("Buy Now page will open and title not matched.");
		}
	}
	
	
	@AfterStep
	public void AfterStep_ForScreenshot(Scenario sc) {
		
		System.out.println("This is After Step after Tear Down Method.");
		
		if(sc.isFailed())
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\ACER\\eclipse-workspace\\Cucumber_Framwork_Learning\\Failed_Scenario_Screenshots\\"+ sc.getName()+".png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("Failed Test Case Screenshot...");

	}


}
