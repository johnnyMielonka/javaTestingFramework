package com.automation.core.DriverFactory;

import com.automation.pages.PageGenerator;
import lombok.Getter;

@Getter
public class PageManager {
    private static final ThreadLocal<PageManager> INSTANCE = ThreadLocal.withInitial(PageManager::new);
    private PageGenerator pageGenerator;

    public static synchronized PageManager getInstance() {
        return INSTANCE.get();
    }

    public static synchronized void cleanUp() {
        INSTANCE.remove();
    }

    public void closeDriver() {
        this.pageGenerator.driver.close();
    }

    public void initialisePageGenerator() {
        this.pageGenerator = new PageGenerator(new DriverSupplier().supplyValue());
    }

}
