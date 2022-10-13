package cucumber.steps;

import com.codeborne.selenide.Condition;
import cucumber.pageobjects.MainPage;
import io.cucumber.java.ru.И;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.page;
import static cucumber.steps.AbstractSteps.bestScroll;

public class ActionSteps {
    MainPage mainPage = page(MainPage.class);

    @И("скролит к элементу {string}")
    public void скролитКЭлементу(String element) {
        mainPage.get(element).shouldBe(Condition.visible, Duration.ofSeconds(10));
        bestScroll(mainPage.get(element));
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
