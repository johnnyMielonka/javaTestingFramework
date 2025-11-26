package com.automation.stepdefinitions.Interview;

import com.automation.core.DriverFactory.PageManager;
import com.automation.pages.PageGenerator;
import com.automation.pages.pageObjects.Interview.AuroraCommonPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuroraCommonPageStepDef {
    private final PageGenerator pageGenerator = PageManager.getInstance().getPageGenerator();
    private final AuroraCommonPage mainPage = pageGenerator.getInstance(AuroraCommonPage.class);


    @Given("Open Aurora web page")
    public void startingPoint() {
        mainPage.openServiceUrl();
    }

    @When("Open {string} item from Menu Bar")
    public void openItemMenuBar(String itemName) {
        mainPage.clickOnManuBarItem(itemName);
    }

    @Then("Verify page title is {string}")
    public void verifyPageTitle(String expectedName) {
        assertEquals("Page name different then expected",
                expectedName.toLowerCase(),
                mainPage.getPageName().toLowerCase());
    }

    @Then("Verify page title is {string} with uppercases")
    public void verifyPageTitleUpperCases(String expectedName) {
        verifyPageTitle(expectedName.toUpperCase());
    }

    @Then("Verify Menu Bar contains following items:")
    public void sofAssertionExample(DataTable inputTable) {
        SoftAssertions softAssertions = new SoftAssertions();
        for (List<String> row : inputTable.asLists()) {
            softAssertions.assertThat(mainPage.checkMenuBarItemVisible(row.get(0))).isEqualTo(row.get(0));
        }
        softAssertions.assertAll();
    }
}
