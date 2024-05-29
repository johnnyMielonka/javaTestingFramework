package com.automation.pages.pageObjects.Interview;

import com.automation.helpers.ServiceUrlProvider;
import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuroraCommonPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//div[@class='template_breadcrumb']")
    private WebElement labelBreadcrumb;

    private final String genericMenuBarItem = "//div[@class='template_nav_main']//a[@class='navitem' and text()='%s']";
    private final String errorPopup = "//*[@class='errorbox']";

    public AuroraCommonPage(WebDriver driver) {
        super(driver);
    }

    public void openServiceUrl() {
        super.openUrl(ServiceUrlProvider.getServiceUrl());
    }

    public AuroraCommonPage clickOnManuBarItem(String elementName) {
        super.click(By.xpath(String.format(genericMenuBarItem, elementName)));
        return this;
    }

    public String getPageName() {
        super.waitForPageLoad();
        String[] breadcrumbs = getText(labelBreadcrumb).split(">");
        return breadcrumbs[breadcrumbs.length - 1].trim();
    }

    public String checkMenuBarItemVisible(String elementName) {
        return super.isVisible(By.xpath(String.format(genericMenuBarItem, elementName))) ? elementName : null;
    }

    public boolean isErrorPopupVisible() {
        return super.isVisible(By.xpath(errorPopup));
    }

    public String getErrorPopupText() {
        return super.getText(driver.findElement(By.xpath(errorPopup)));
    }

}
