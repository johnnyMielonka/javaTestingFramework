package com.Automation.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("Starting point")
    public void startingPoint() {
        System.out.print("Starting point");
    }

    @When("Continuation {string}")
    public void continuation(String value) throws InterruptedException {
        Thread.sleep(Integer.valueOf(value) * 1000);
        System.out.printf("Continuation at %s", value);
    }

    @Then("Finish")
    public void finish() {
        System.out.print("Finish");
    }

    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) throws InterruptedException {
        Thread.sleep(2000);
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario,file);
    }
}
