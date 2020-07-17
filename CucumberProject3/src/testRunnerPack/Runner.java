package testRunnerPack;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(ExtendedCucumber.class)	
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        overviewReport = true,
        outputFolder = "${user.dir}/DATE(dd-MM-yyyy)") /*,
        reportPrefix = "results-${user}")*/
@CucumberOptions(features="Features/Login.feature",glue={"stepDefinition"},
				 plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"})
public class Runner {

}
