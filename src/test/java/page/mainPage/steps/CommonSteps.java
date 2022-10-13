package page.mainPage.steps;

import data.pattern.regexPattern;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

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

    @Step("Вывод в консоль названия элемента")
    public static void print(SelenideElement element) {
        System.out.println(element.getText());
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

    @Step("Название блока")
    public static void nameBlock(SelenideElement element, String nameOfBlock) {
        assertThat(element.getText()).as("Неверно указано название блока").isEqualTo(nameOfBlock);
        print(element);
    }


}
