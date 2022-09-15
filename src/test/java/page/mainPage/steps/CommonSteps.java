package page.mainPage.steps;

import data.regexPattern;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    @Step("Проверка, что название корректно. Regex")
    public static void assertNameRegex(SelenideElement element) {
        Boolean regName = Pattern.matches(regexPattern.regexName(), element.getText());
        System.out.println(element.getText());
        assertThat(regName).as("Неверно указано название фильма").isTrue();
    }

    @Step("Проверка, что ссылка корректна. Regex")
    public static void assertHrefRegex(SelenideElement element) {
        Boolean regLink = Pattern.matches(regexPattern.regexFilmOrSeriesLink(), element.getAttribute("href"));
        System.out.println(element.getAttribute("href"));
        System.out.println(element.getText());
        assertThat(regLink).as("Неверно указана ссылка фильма").isTrue();
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public static void assertYearAndGenreRegex(SelenideElement element) {
        Boolean regYear = Pattern.matches(regexPattern.regexYearAndGenre(), element.getText());
        System.out.println(element.getText());
        assertThat(regYear).as("Неверно указан жанр или год фильма").isTrue();
    }

    @Step("Проверка, что рейтинг корректный. Regex")
    public static void assertRatingRegex(SelenideElement element) {
        Boolean regGenre = Pattern.matches(regexPattern.regexRating(), element.getText());
        System.out.println(element.getText());
        assertThat(regGenre).as("Неверно указан рейтинг фильма").isTrue();
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public static void scroll(SelenideElement backArrow, SelenideElement forwardArrow) {
        backArrow.shouldBe(Condition.hidden);
        forwardArrow.click();
        backArrow.shouldBe(Condition.visible);
    }

    @Step("Название блока")
    public static void nameBlock(SelenideElement element, String nameOfBlock) {
        assertThat(element.getText()).as("Неверно указано название блока").isEqualTo(nameOfBlock);
        System.out.println(element.getText());
    }


}
