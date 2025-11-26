package com.automation.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.automation")
@IncludeTags("demo")
@ConfigurationParameters({
        @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features/"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.automation.stepdefinitions"),
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value ="pretty," +
                "html:target/cucumber-reports/cucumber-pretty.html, " +
                "json:target/cucumber-reports/CucumberTestReport.json, " +
                "timeline:target/test-output-thread/"),
        @ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true"),
        @ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase"),
        @ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true"),
        @ConfigurationParameter(key = PARALLEL_CONFIG_STRATEGY_PROPERTY_NAME, value = "fixed"),
        @ConfigurationParameter(key = PARALLEL_CONFIG_FIXED_PARALLELISM_PROPERTY_NAME, value = "1"),
        @ConfigurationParameter(key = PARALLEL_CONFIG_FIXED_MAX_POOL_SIZE_PROPERTY_NAME, value = "2")
})
public class TestRunner {
}