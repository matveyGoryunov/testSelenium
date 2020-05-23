package ru.nitrouz.testselenium.behaviors;

import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import io.qameta.allure.Step;
import ru.nitrouz.testselenium.citrus.WaitForPageFullyLoad;

public class GoHome extends AbstractTestBehavior {


    @Override
    public void apply() {
        loadMainPage();
    }

    @Step("Возвращаемся на главную страницу")
    private void loadMainPage() {
        selenium(action -> action
                .navigate("${url}")
        );

        run(new WaitForPageFullyLoad());
    }
}
