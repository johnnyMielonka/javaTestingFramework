package com.Automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@all",
        glue = "com.Automation.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "timeline:target/test-output-thread/"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {
}