package com.automation.stepdefinitions.Interview;

import com.automation.core.DriverFactory.PageManager;
import com.automation.pages.PageGenerator;
import com.automation.pages.pageObjects.Interview.AuroraCommonPage;
import com.automation.pages.pageObjects.Interview.AuroraLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuroraLoginPageStepDef {
    private final PageGenerator pageGenerator = PageManager.getInstance().getPageGenerator();
    private final AuroraLoginPage loginPage = pageGenerator.getInstance(AuroraLoginPage.class);
    private final AuroraCommonPage mainPage = pageGenerator.getInstance(AuroraCommonPage.class);

    @Given("Navigate to login page")
    public void navigateToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("Log in as {string} user and {string} password")
    public void loginAsUserPassword(String user, String password) {
        loginPage.setEmailForLogin(user)
                .setPasswordForLogin(password)
                .pressLogIn();
    }

    @Then("Verify if error popup is visible")
    public void verifyErrorPopupIsVisible() {
        assertTrue("No error is visible", mainPage.isErrorPopupVisible());
    }

    @Then("Verify error popup exist with text:")
    public void verifyErrorPopupHasText(String expectedErrorText) {
        assertEquals(
                expectedErrorText.toLowerCase(),
                mainPage.getErrorPopupText().toLowerCase());
    }
}
