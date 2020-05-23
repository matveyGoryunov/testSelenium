package ru.nitrouz.testselenium.behaviors;

import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import io.qameta.allure.Step;
import ru.nitrouz.testselenium.citrus.WaitForPageFullyLoad;
import ru.nitrouz.testselenium.pages.ComparisonPage;
import ru.nitrouz.testselenium.pages.MainPage;

public class CheckComparisonPage extends AbstractTestBehavior {

    private MainPage mainPage = new MainPage();
    private ComparisonPage comparisonPage = new ComparisonPage();

    @Override
    public void apply() {
        openComparisonPage();
        validateComparisonPage();
    }

    @Step("Переходим к странице сравнения")
    private void openComparisonPage() {
        selenium(action -> action
                .page(mainPage)
                .execute("goToComparison")
        );

        run(new WaitForPageFullyLoad());
    }

    @Step("Проверяем страницу сравнения")
    private void validateComparisonPage() {
        selenium(action -> action
                .page(comparisonPage)
                .validate()
        );
    }
}
