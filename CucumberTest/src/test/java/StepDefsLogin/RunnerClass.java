package StepDefsLogin;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepDefsLogin" }, monochrome = true,

		plugin = { "pretty", "json:target/JSONReports/report.json", "html:target/HtmlReports",
				"junit:target/JUnitReports/report.xml" }, tags = "@Flipkart")

public class RunnerClass {

}
