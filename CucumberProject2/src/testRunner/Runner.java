package testRunner;
import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features/ParseXML.feature",glue={"stepDefinition"},
				 plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"})
public class Runner {

}
