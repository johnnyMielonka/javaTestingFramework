package automation.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @Given("Starting point")
    public void startingPoint() {
        System.out.printf("Starting point");
    }

    @When("Continuation")
    public void continuation() {
        System.out.printf("Continuation");
    }

    @Then("Finish")
    public void finish() {
        System.out.printf("Finish");
    }
}
