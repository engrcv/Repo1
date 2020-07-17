package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features/Login.feature",glue={"stepDefinition"},
				 plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"})
public class TestRunner {

}
