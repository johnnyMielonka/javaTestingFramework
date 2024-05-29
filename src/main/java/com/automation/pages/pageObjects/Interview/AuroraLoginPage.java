package com.automation.pages.pageObjects.Interview;

import com.automation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuroraLoginPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//li[@class='template_nav_top_members']/a[text()='Login']")
    private WebElement topBarLogin;
    @FindBy(how = How.XPATH, using = "//input[@name='email_address' and @id='email_address']")
    private WebElement inputEmailLogin;
    @FindBy(how = How.XPATH, using = "//input[@name='password' and @id='password']")
    private WebElement inputPassword;
    @FindBy(how = How.XPATH, using = "//input[@type='submit' and @name='login']")
    private WebElement btnLogin;

    public AuroraLoginPage(WebDriver driver) {
        super(driver);
    }

    public AuroraLoginPage navigateToLoginPage() {
        super.click(topBarLogin);
        return this;
    }

    public AuroraLoginPage setEmailForLogin(String textValue) {
        super.writeText(inputEmailLogin, textValue);
        return this;
    }

    public AuroraLoginPage setPasswordForLogin(String textValue) {
        super.writeText(inputPassword, textValue);
        return this;
    }

    public AuroraLoginPage pressLogIn() {
        super.click(btnLogin);
        return this;
    }


}
