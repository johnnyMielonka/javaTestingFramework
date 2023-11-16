package com.automation.stepdefinitions;


import com.automation.core.DriverFactory.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class StepDefConfiguration {
    @Before("@api")
    public void beforeApi() {
    }

    @Before("@gui")
    public void beforeGui() {
        PageManager.getInstance().initialisePageGenerator();
    }

    @After("@api")
    public void cleanApi() {
    }

    @After("@gui")
    public void cleanGui(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.takeScreenshot(), "image/png", scenario.getName());
        }
        PageManager.getInstance().closeDriver();
        PageManager.cleanUp();
    }

    private byte[] takeScreenshot() {
        WebDriver driver = PageManager.getInstance().getPageGenerator().driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}