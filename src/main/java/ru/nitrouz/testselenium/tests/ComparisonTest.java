package ru.nitrouz.testselenium.tests;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.selenium.endpoint.SeleniumBrowser;
import com.consol.citrus.testng.CitrusParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.nitrouz.testselenium.behaviors.AddItemToComparison;
import ru.nitrouz.testselenium.behaviors.CheckComparisonPage;
import ru.nitrouz.testselenium.behaviors.GoHome;
import ru.nitrouz.testselenium.behaviors.SearchItem;

public class ComparisonTest extends TestNGCitrusTestRunner {

    private SearchItem searchItemBehavior = new SearchItem();
    private AddItemToComparison addItemToComparisonBehavior = new AddItemToComparison();
    private GoHome goHomeBehavior = new GoHome();
    private CheckComparisonPage checkComparisonPageBehavior = new CheckComparisonPage();


    @Autowired
    private SeleniumBrowser seleniumBrowser;

    @DataProvider(name = "mobilePhonesDP")
    public Object[][] mobilePhonesDP() {
        return new Object[][]{
                new Object[]{"Apple iPhone 11 Pro Max", "Xiaomi Mi A1"},
                new Object[]{"Apple iPhone 7 plus", "Samsung Galaxy S10"},
                new Object[]{"Samsung Galaxy Note 10", "Samsung Galaxy S20 Ultra"}
        };
    }

    @Test(dataProvider = "mobilePhonesDP", description = "Тестирование сравнения двух телефонов")
    @CitrusTest
    @CitrusParameters({"firstPhone", "secondPhone"})
    public void testRequests(String firstPhone, String secondPhone) {

        //Добавляем первое устройство в список сравнения
        variable("phone",firstPhone);
        applyBehavior(searchItemBehavior);
        applyBehavior(addItemToComparisonBehavior);
        applyBehavior(goHomeBehavior);

        //Добавляем второе устройство в список сравнения
        variable("phone",secondPhone);
        applyBehavior(searchItemBehavior);
        applyBehavior(addItemToComparisonBehavior);
        applyBehavior(goHomeBehavior);

        //Открываем и проверяем страницу сравнения
        applyBehavior(checkComparisonPageBehavior);
    }
}
