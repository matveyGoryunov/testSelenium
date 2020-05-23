package ru.nitrouz.testselenium.pages;


import com.consol.citrus.selenium.model.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage implements WebPage {

    @FindBy(className = "radio-button__radio_side_left")
    private WebElement gridButton;

    @FindBy(className = "n-snippet-cell2__image")
    private WebElement firstItem;

    public void changeViewToGrid() {
        gridButton.click();
    }

    public void selectFirstItem() {
        firstItem.click();
    }


}
