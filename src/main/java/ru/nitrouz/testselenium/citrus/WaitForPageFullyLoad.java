package ru.nitrouz.testselenium.citrus;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageFullyLoad extends AbstractTestAction {

    private long timeout = 120L;

    public WaitForPageFullyLoad timeout(Long millis) {
        this.timeout = millis / 1000;
        return this;
    }

    @Override
    public void doExecute(TestContext testContext) {
        WebDriver driver = testContext.getApplicationContext().getBean(testContext.getVariable("selenium_browser"), SeleniumBrowser.class).getWebDriver();
        new WebDriverWait(driver, timeout).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
