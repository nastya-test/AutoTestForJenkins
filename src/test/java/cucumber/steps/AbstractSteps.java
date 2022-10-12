package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.regexPattern;
import io.qameta.allure.Step;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractSteps {
    @Step("Соответствие текста элемента ожидаемому тексту")
    public static void textOfElement(SelenideElement element, String text) {
        assertThat(element.getText()).as("Неверно указан текст эелемента").isEqualTo(text);
        print(element);
    }

    @Step("Вывод в консоль названия элемента")
    public static void print(SelenideElement element) {
        System.out.println(element.getText());
    }

    @Step("Соответствие регулярному выражению текста элемента")
    private static void assertTextRegex(SelenideElement element, String regPattern) {
        Boolean reg = Pattern.matches(regPattern, element.getText());
        print(element);
        assertThat(reg).as("Текст элемента не соответствует регулярному выражению").isTrue();
    }

    @Step("Соответствие регулярному выражению ссылки элемента")
    private static void assertLinkRegex(SelenideElement element, String regPattern) {
        Boolean regLink = Pattern.matches(regPattern, element.getAttribute("href"));
        System.out.println(element.getAttribute("href"));
        print(element);
        assertThat(regLink).as("Ссылка элемента не соответствует регулярному выражению").isTrue();
    }

    @Step("Подскролл к элементу")
    public static void bestScroll(SelenideElement element) {
        element.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
    }

    @Step("Подскролл к элементу")
    public static void best2Scroll(SelenideElement element) {
        element.scrollIntoView("{behavior: \"instant\", block: \"start\", inline: \"end\"}");
    }


    @Step("Проверка, что название корректно. Regex")
    public static void assertNameRegex(SelenideElement element) {
        assertTextRegex(element, regexPattern.regexName());
    }

    @Step("Проверка, что ссылка фильма/сериала корректна. Regex")
    public static void assertHrefRegex(SelenideElement element) {
        assertLinkRegex(element, regexPattern.regexFilmOrSeriesLink());
    }

    @Step("Проверка, что ссылка лейбла билеты корректна. Regex")
    public static void assertHrefTicketsRegex(SelenideElement element) {
        assertLinkRegex(element, regexPattern.regexLabelTickets());
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public static void assertYearAndGenreRegex(SelenideElement element) {
        assertTextRegex(element, regexPattern.regexYearAndGenre());
    }

    @Step("Проверка, что рейтинг корректный. Regex")
    public static void assertRatingRegex(SelenideElement element) {
        assertTextRegex(element, regexPattern.regexRating());
    }

    @Step("Проверка, что колличество комментариев корректно. Regex")
    public static void assertCommentRegex(SelenideElement element) {
        assertTextRegex(element, regexPattern.commentNewsPopular());
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public static void scroll(SelenideElement backArrow, SelenideElement forwardArrow) {
        backArrow.shouldBe(Condition.hidden);
        bestScroll(forwardArrow);
        forwardArrow.click();
        backArrow.shouldBe(Condition.visible);
    }

}
