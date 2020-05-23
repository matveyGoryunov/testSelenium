package ru.nitrouz.testselenium.citrus;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAllElements extends AbstractTestAction {

    private long timeout = 5L;
    private By by;

    public WaitForAllElements() {
    }

    public WaitForAllElements timeout(Long millis) {
        this.timeout = millis / 1000;
        return this;
    }

    public WaitForAllElements element(By by) {
        this.by = by;
        return this;
    }


    @Override
    public void doExecute(TestContext testContext) {
        WebDriver driver = testContext.getApplicationContext().getBean(testContext.getVariable("selenium_browser"), SeleniumBrowser.class).getWebDriver();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}