package StepDefinition;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.BuyNowPage;
import PageObject.MobileToPincode;
import Utilities.ReadConfig;
import io.cucumber.java.Scenario;

public class BaseClass {

	
	public static WebDriver driver;
	public MobileToPincode MobToPin;
	public BuyNowPage BnP;
	
	public static Logger log;
	public ReadConfig readConfig;

}
