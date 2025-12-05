package com.automation.stepdefinitions;

import com.automation.api.endpoints.EndpointCall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;

@Slf4j
public class apiStepDef {

    private final EndpointCall endpointCall = new EndpointCall();

    @Given("Starting point API")
    public void startingPointAPI() {
        System.out.print(this.getClass().getName() + " starting point");
    }

    @Given("Web Api get call")
    public void makeGetCallToService() {
        System.out.print(this.getClass().getName() + " starting point");
        endpointCall.makeGetCallToService();
    }

    @When("Print response body")
    public void printResponse() {
        log.info(endpointCall.getResponseBody());
    }

    @Then("Verify response code is {int}")
    public void verifyResponseCode(int expectedResponseCode) {
        Assertions.assertThat(endpointCall.getStatusCode())
                .isEqualTo(expectedResponseCode);
    }
}
