package com.automation.stepdefinitions.Interview;

import com.automation.core.DriverFactory.PageManager;
import com.automation.pages.PageGenerator;
import com.automation.pages.pageObjects.Interview.AuroraCommonPage;
import com.automation.pages.pageObjects.Interview.AuroraLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

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
        Assertions.assertThat(mainPage.isErrorPopupVisible())
                .isEqualTo(true)
                .as("No error is visible");
    }

    @Then("Verify error popup exist with text:")
    public void verifyErrorPopupHasText(String expectedErrorText) {
        Assertions.assertThat(mainPage.getErrorPopupText().toLowerCase())
                .isEqualTo(expectedErrorText.toLowerCase());
    }
}
