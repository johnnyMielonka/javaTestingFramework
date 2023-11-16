package com.automation.stepdefinitions;

import com.automation.core.DriverFactory.PageManager;
import com.automation.helpers.TestContext;
import com.automation.pages.PageGenerator;
import com.automation.pages.pageObjects.GenericPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class guiStepDef {
    private final PageGenerator pageGenerator = PageManager.getInstance().getPageGenerator();
    private final GenericPage genericPage = pageGenerator.getInstance(GenericPage.class);
    private final SoftAssertions softAssertions = new SoftAssertions();

    @Given("Starting point")
    public void startingPoint() {
        System.out.print("Starting point");
        genericPage.openServiceUrl();
    }

    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) throws InterruptedException {
        Thread.sleep(2000);
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario, file);
    }

    @When("Continuation {string}")
    public void continuation(String value) throws InterruptedException {
        Thread.sleep(Integer.valueOf(value) * 1000);
        this.genericPage.externalCall(value);
    }
    @When("Save {string} to context TEMP")
    public void saveToContext(String value)  {
        this.genericPage.saveToContextTemp(value);
    }

    @Then("Verify if first column equals second:")
    public void sofAssertionExample(DataTable inputTable) {
        for (List<String> row : inputTable.asLists()) {
            softAssertions.assertThat(row.get(0)).isEqualTo(row.get(1));
        }
        softAssertions.assertAll();
    }
    @Then("Verify if context TEMP has {string} value")
    public void contextCehckExample(String expectedValue){
        assertEquals(expectedValue, genericPage.getFromContextTemp());
    }
}
