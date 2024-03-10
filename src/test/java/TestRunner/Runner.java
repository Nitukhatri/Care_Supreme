package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
	//	tags="@Regression or @Sanity",
		plugin = {"pretty","html:target/cucumber-reports/Compelete_result.html"}
		)


public class Runner {

}
