package automation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "automation/features",
        tags = "@all",
        glue = "automation/stepdefinitions",
        plugin = {"pretty"}
)

public class TestRunner {
}