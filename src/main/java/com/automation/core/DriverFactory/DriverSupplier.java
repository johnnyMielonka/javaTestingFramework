package com.automation.core.DriverFactory;

import com.automation.core.DriverType;
import com.automation.helpers.EnvPropertiesProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverSupplier {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriveSupplier = () -> {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--verbose");
        options.addArguments("--no-sandbox");
        options.addArguments("--whitelisted-ips=''");

        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.chromedriver().setup();

        return new ChromeDriver(options);
    };
    private static final Supplier<WebDriver> safariDriveSupplier = () -> {
        SafariOptions options = new SafariOptions();

        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.safaridriver().setup();

        return new SafariDriver(options);
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriveSupplier);
        driverMap.put(DriverType.SAFARI, safariDriveSupplier);
    }

    private DriverType driverType;
    private WebDriver driver;

    private static final String DRIVERPROPERTY = EnvPropertiesProvider.getBrowser();

    WebDriver supplyValue(){
        this.selectDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private void selectDriver(){
        switch (DRIVERPROPERTY){
            case "chrome":
                driverType = DriverType.CHROME;
                break;
            case "safari":
                driverType = DriverType.SAFARI;
                break;
            default:
                throw new RuntimeException("Unsupported webdriver: " + DRIVERPROPERTY);
        }
        driver = driverMap.get(driverType).get();
    }

}
