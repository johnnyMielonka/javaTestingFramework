package com.automation.pages.pageObjects;

import com.automation.helpers.ServiceUrlProvider;
import com.automation.helpers.TestContext;
import com.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class GenericPage extends BasePage {
    public GenericPage(WebDriver driver) {
        super(driver);
    }

    public GenericPage openServiceUrl(){
        super.openUrl(ServiceUrlProvider.getServiceUrl());
        return this;
    }

    public void externalCall(String param) {
        System.out.print("Param" + param);
    }

    public void saveToContextTemp(String value) {
        TestContext.TEMP.setValue(value);
    }

    public String getFromContextTemp() {
        return TestContext.TEMP.getValue();
    }
}
