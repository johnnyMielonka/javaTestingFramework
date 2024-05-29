package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends PageGenerator {
    public static final int PAGE_LOAD_TIMEOUT = 15;

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

    protected void click (WebElement element){
        this.waitForPageLoad();
        element.click();
    }
    protected void writeText(WebElement element, String textValue){
        this.waitForPageLoad();
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getText(WebElement element){
        this.waitForPageLoad();
        return element.getText();
    }

    protected boolean isVisible(By element){
        this.waitForPageLoad();
        return !super.driver.findElements(element).isEmpty();
    }

}
