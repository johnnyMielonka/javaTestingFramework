package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends PageGenerator {
    public static final int PAGE_LOAD_TIMEOUT = 15;
    public static final int WAIT_TIMEOUT = 10;
    public static final int WAIT_POLLING = 1;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    protected void openUrl(String url) {
        driver.get(url);
        this.waitForPageLoad();
    }

    protected void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadStatus = driver1 -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        wait.until(pageLoadStatus);
    }

    private FluentWait<WebDriver> waitUntil(Duration timeout, Duration polling) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(NoSuchElementException.class);
    }

    protected FluentWait<WebDriver> waitUntil() {
        return this.waitUntil(Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofSeconds(WAIT_POLLING));
    }

    protected void click(By element) {
        this.waitForPageLoad();
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getText(WebElement element){
        this.waitForPageLoad();
        return element.getText();
    }

    protected boolean isVisible(By element) {
        this.waitForPageLoad();
        return !super.driver.findElements(element).isEmpty();
    }

}
