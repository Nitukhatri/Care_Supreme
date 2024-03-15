package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.BuyNowPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_BuyNowPage extends BaseClass{

	
	//////////////////// BUY NOW PAGE //////////////////

	String OldPremium = "";

	@When("Total Coverage Slider move to select SI as {string}")
	public void total_coverage_slider_move_to_select_si_as(String SI) {
	
		BnP = new BuyNowPage(driver);
		
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(BnP.Slider));
		
		switch (SI) {
		case "7":
			new Actions(driver).dragAndDropBy(BnP.Slider, 0, 0).perform();
			log.info("SI 7L");
			break;

		case "10":
			new Actions(driver).dragAndDropBy(BnP.Slider, 0, 0).perform();
			new Actions(driver).dragAndDropBy(BnP.Slider, 20, 0).perform();
			log.info("SI 10L");
			break;

		case "15":
			new Actions(driver).dragAndDropBy(BnP.Slider, 40, 0).perform();
			log.info("SI 15L");
			break;

		case "25":
			new Actions(driver).dragAndDropBy(BnP.Slider, 60, 0).perform();
			log.info("SI 25L");
			break;

		case "50":
			new Actions(driver).dragAndDropBy(BnP.Slider, 80, 0).perform();
			log.info("SI 50L");
			break;

		case "100":
			new Actions(driver).dragAndDropBy(BnP.Slider, 100, 0).perform();
			log.info("SI 100L");
			break;

		default:
			log.info("SI not in Option......");
			break;
		}
		
		
	}

	@Then("Total Premium should update")
	public void total_premium_should_update() {
		/*
		 * String UpdatedPremium = BnP.TotalPremium.getText(); if
		 * (UpdatedPremium.contentEquals(OldPremium)) { Assert.assertTrue(false); } else
		 * { Assert.assertTrue(true); }
		 */
	}
	

}
