package cucumber.steps;

import com.codeborne.selenide.Condition;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.mainPage.MainPage;
import io.cucumber.java.ru.И;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static cucumber.map.PageMap.activePageMap;
import static cucumber.steps.AbstractSteps.bestScroll;

public class ActionSteps {
//    MainPage mainPage = page(MainPage.class);
    AbstractPage mainPage = activePageMap.get(true);

    @И("скролит к элементу {string}")
    public void скролитКЭлементу(String element) {
        bestScroll(mainPage.get(element));
        sleep(2000);
    }

    @И("наводит на элемент {string}")
    public void наводитНаЭлемент(String element) {
        mainPage.get(element).hover();
    }

    @И("нажимает на элемент {string}")
    public void нажимаетНаЭлемент(String element) {
        mainPage.get(element).click();
    }

    @И("вводит в поле {string} значение {string}")
    public void вводитВПолеЗначение(String element, String text) {
        mainPage.get(element).click();
        mainPage.get(element).sendKeys(text);
    }
}
