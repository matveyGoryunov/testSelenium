package ru.nitrouz.testselenium.citrus;

import com.consol.citrus.actions.AbstractTestAction;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class FocusToNewTab extends AbstractTestAction {


    @Override
    public void doExecute(TestContext testContext) {
        WebDriver driver = testContext.getApplicationContext().getBean(testContext.getVariable("selenium_browser"), SeleniumBrowser.class).getWebDriver();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }
}
