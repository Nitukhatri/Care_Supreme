package TestRunner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
	//	tags = "@sanity",	// execute only those scenario which write under sanity tags
				plugin = {"pretty","html:target/cucumber-reports/Compelete_result.html"}
	)

public class Runner extends AbstractTestNGCucumberTests {
	
//	This class will Empty.

}

