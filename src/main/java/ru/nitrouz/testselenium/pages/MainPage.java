package ru.nitrouz.testselenium.pages;

import com.consol.citrus.selenium.model.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage implements WebPage {

    @FindBy(id = "header-search")
    private WebElement searchField;

    @FindBy(xpath = "//*[text()='Сравнение']//parent::span//parent::div//parent::span//parent::a")
    private WebElement comparisonButton;

    public void fillSearchField(String searchString) {
        searchField.sendKeys(searchString);
    }

    public void goToComparison() {
        comparisonButton.click();
    }

    public void submit() {
        searchField.submit();
    }

}
