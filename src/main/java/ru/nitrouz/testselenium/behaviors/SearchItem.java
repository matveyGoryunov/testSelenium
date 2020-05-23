package ru.nitrouz.testselenium.behaviors;

import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.nitrouz.testselenium.citrus.WaitForElement;
import ru.nitrouz.testselenium.pages.MainPage;

public class SearchItem extends AbstractTestBehavior {

    private MainPage mainPage = new MainPage();


    @Override
    public void apply() {
        fillSearchField();
        submitSearch();
        waitForSearchResults();
    }

    @Step("Заполняем строку поиска")
    private void fillSearchField() {
        selenium(action -> action
                .page(mainPage)
                .argument("${phone}")
                .execute("fillSearchField")
        );
    }

    @Step("Нажимаем кнопку поиска")
    private void submitSearch() {
        selenium(action -> action
                .page(mainPage)
                .execute("submit")
        );
    }

    @Step("Ожидаем открытие страницы с результатами поиска")
    private void waitForSearchResults() {
        run(new WaitForElement()
                .element(By.className("layout_type_search")));
    }
}
