package ru.nitrouz.testselenium.citrus;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement extends AbstractTestAction {

    private long timeout = 60L;
    private By by;
    private boolean isMustBeClickable = false;

    public WaitForElement() {
    }

    public WaitForElement timeout(Long millis) {
        this.timeout = millis / 1000;
        return this;
    }

    public WaitForElement element(By by) {
        this.by = by;
        return this;
    }

    public WaitForElement mustBeClickable() {
        this.isMustBeClickable = true;
        return this;
    }

    @Override
    public void doExecute(TestContext testContext) {
        WebDriver driver = testContext.getApplicationContext().getBean(testContext.getVariable("selenium_browser"), SeleniumBrowser.class).getWebDriver();
        if(isMustBeClickable) {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
        } else {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }
}
