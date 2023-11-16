package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends PageGenerator {
    public static final int PAGE_LOAD_TIMEOUT = 15;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void openUrl(String url) {
        driver.get(url);
        this.waitForPageLoad();
    }

    public void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadStatus = driver1 -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        wait.until(pageLoadStatus);
    }

}
