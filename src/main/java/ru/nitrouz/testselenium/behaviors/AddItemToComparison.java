package ru.nitrouz.testselenium.behaviors;

import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.nitrouz.testselenium.citrus.FocusToNewTab;
import ru.nitrouz.testselenium.citrus.WaitForElement;
import ru.nitrouz.testselenium.citrus.WaitForPageFullyLoad;
import ru.nitrouz.testselenium.pages.ItemPage;
import ru.nitrouz.testselenium.pages.SearchResultsPage;

public class AddItemToComparison extends AbstractTestBehavior {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private ItemPage itemPage = new ItemPage();

    @Override
    public void apply() {
        selectFirstItem();
        waitForItemPage();
        validateItemPage();
        addItemToComparison();
        validateInformer();
    }

    @Step("Открываем страничку первого найденного устройства")
    private void selectFirstItem() {
        selenium(action -> action
                .page(searchResultsPage)
                .execute("changeViewToGrid")
        );

        run(new WaitForElement()
                .element(By.className("n-snippet-cell2"))
        );

        selenium(action -> action
                .page(searchResultsPage)
                .execute("selectFirstItem")
        );
    }

    @Step("Ожидаем открытия страницы выбранного товара")
    private void waitForItemPage() {
        run(new FocusToNewTab());

        run(new WaitForPageFullyLoad());
    }

    @Step("Проверяем, что открылась ожидаемая страница")
    private void validateItemPage() {
        selenium(action -> action
                .page(itemPage)
                .argument("${phone}")
                .validate()
        );
    }

    @Step("Добавляем устройство в сравнение")
    private void addItemToComparison() {
        selenium(action -> action
                .page(itemPage)
                .execute("addItemToComparison")
        );
    }

    @Step("Проверяем текст уведомления о добавлении устройства в сравнение")
    private void validateInformer() {
        run(new WaitForElement()
                .element(By.className("popup-informer__pane"))
                .timeout(10000L)
        );

        selenium(action -> action
                .page(itemPage)
                .execute("validateInformer")
        );
    }
}
