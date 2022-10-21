package cucumber.steps;

import cucumber.pageobjects.AbstractPage;
import io.cucumber.java.ru.И;
import static com.codeborne.selenide.Selenide.sleep;
import static cucumber.map.PageMap.activePageMap;
import static cucumber.steps.AbstractSteps.bestScroll;

public class ActionSteps {

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
        bestScroll(mainPage.get(element));
        mainPage.get(element).click();
    }

    @И("вводит в поле {string} значение {string}")
    public void вводитВПолеЗначение(String element, String text) {
        mainPage.get(element).click();
        mainPage.get(element).sendKeys(text);
    }
}
