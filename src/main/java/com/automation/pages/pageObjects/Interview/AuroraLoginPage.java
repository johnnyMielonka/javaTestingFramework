package com.automation.pages.pageObjects.Interview;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuroraLoginPage extends BasePage {
    private final String topBarLogin = "//li[@class='template_nav_top_members']/a[text()='Login']";
    private final String inputEmailLogin = "//input[@name='email_address' and @id='email_address']";
    private final String inputPassword = "//input[@name='password' and @id='password']";
    private final String btnLogin = "//input[@type='submit' and @name='login']";

    public AuroraLoginPage(WebDriver driver) {
        super(driver);
    }

    public AuroraLoginPage navigateToLoginPage() {
        super.click(By.xpath(topBarLogin));
        return this;
    }

    public AuroraLoginPage setEmailForLogin(String textValue) {
        super.writeText(By.xpath(inputEmailLogin), textValue);
        return this;
    }

    public AuroraLoginPage setPasswordForLogin(String textValue) {
        super.writeText(By.xpath(inputPassword), textValue);
        return this;
    }

    public AuroraLoginPage pressLogIn() {
        super.click(By.xpath(btnLogin));
        return this;
    }


}
