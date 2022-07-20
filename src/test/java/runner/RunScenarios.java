package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin={"pretty"},
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = {"@ValidateLocation&Routes"}        
        )

public class RunScenarios extends AbstractTestNGCucumberTests{
	
}
