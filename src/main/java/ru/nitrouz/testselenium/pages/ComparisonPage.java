package ru.nitrouz.testselenium.pages;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import com.consol.citrus.selenium.model.PageValidator;
import com.consol.citrus.selenium.model.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ComparisonPage implements WebPage, PageValidator<ComparisonPage> {

    @FindBy(xpath = "//div[contains(@class, 'n-compare-cell-draggable')]")
    private List<WebElement> itemsForComparison;


    @Override
    public void validate(ComparisonPage comparisonPage, SeleniumBrowser seleniumBrowser, TestContext testContext) {
        Assert.assertEquals(itemsForComparison.size(),2);
    }
}
