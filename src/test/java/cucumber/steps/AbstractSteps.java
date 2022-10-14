package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;

public class AbstractSteps {

    @Step("Вывод в консоль названия элемента")
    private static void print(SelenideElement element) {
        System.out.println(element.getText());
    }

    @Step("Соответствие текста элемента ожидаемому тексту")
    public static void assertTextOfElement(SelenideElement element, String text) {
        assertThat(element.getText()).as("Неверно указан текст эелемента").isEqualTo(text);
        print(element);
    }

    @Step("Соответствие ссылки элемента ожидаемомой ссылке")
    public static void assertLinkOfElementText(SelenideElement element, String text) {
        assertThat(element.getText()).as("Неверно указана ссылка эелемента").isEqualTo(text);
        print(element);
    }

    @Step("Соответствие ссылки элемента ссылке другого элемента")
    public static void assertCompareLinkOfElements(SelenideElement element1, SelenideElement element2) {
        assertThat(element1.getAttribute("href")).as("Ссылка новости не совпала с цветом картинки")
                .isEqualTo(element2.getAttribute("href"));
    }

    @Step("Соответствие регулярному выражению текста элемента")
    public static void assertTextRegex(SelenideElement element, String regPattern) {
        Boolean reg = Pattern.matches(regPattern, element.getText());
        print(element);
        assertThat(reg).as("Текст элемента не соответствует регулярному выражению").isTrue();
    }

    @Step("Соответствие регулярному выражению ссылки элемента")
    public static void assertLinkRegex(SelenideElement element, String regPattern) {
        Boolean regLink = Pattern.matches(regPattern, element.getAttribute("href"));
        System.out.println(element.getAttribute("href"));
        print(element);
        assertThat(regLink).as("Ссылка элемента не соответствует регулярному выражению").isTrue();
    }

    @Step("Подскролл к элементу")
    public static void bestScroll(SelenideElement element) {
        element.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
    }

    @Step("Отображение элемента")
    public static void assertVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    @Step("Цвет элемента")
    public static void assertColour(SelenideElement element, String colour) {
        assertThat(element.getCssValue("color")).isEqualTo(colour);
    }

    @Step("Количество элементов в ElementsCollection")
    public static void assertCountElementCollection(ElementsCollection elements, int count) {
        assertThat(elements.size()).isEqualTo(count);
    }

    @Step("Есть изображение")
    public static void assertIsImage(SelenideElement element) {
        element.isImage();
    }

    @Step("Значение font-weight")
    public static void assertFontWeight(SelenideElement element, String value) {
        assertThat(element.getCssValue("font-weight")).isEqualTo(value);
    }

    @Step("Стрелки прокуртки карусели")
    public static void assertHidden(SelenideElement element) {
        element.shouldBe(Condition.hidden);
    }


}
