package ru.nitrouz.testselenium.pages;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import com.consol.citrus.selenium.model.PageValidator;
import com.consol.citrus.selenium.model.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemPage implements WebPage, PageValidator<ItemPage> {

    @FindBy(xpath = "//*[text()='Сравнить']//preceding::div[1]")
    private WebElement compareButton;

    @FindBy(tagName = "h1")
    private WebElement heading;

    @FindBy(className = "popup-informer__close")
    private WebElement closeInformerButton;

    @FindBy(className = "popup-informer__title")
    private WebElement popupInformerTitle;

    public void addItemToComparison() {
        compareButton.click();
    }

    public void verifyInformer() {
        Assert.assertTrue(popupInformerTitle.getText().contains("добавлен к сравнению"));
    }

    @Override
    public void validate(ItemPage itemPage, SeleniumBrowser seleniumBrowser, TestContext testContext) {
        Assert.assertTrue(heading.getText().toLowerCase().contains(testContext.getVariable("phone").toLowerCase()));
    }
}
