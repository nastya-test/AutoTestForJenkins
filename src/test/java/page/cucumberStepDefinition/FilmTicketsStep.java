package page.cucumberStepDefinition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.Constants.linkTicketsBlock;
import static org.assertj.core.api.Assertions.assertThat;
import static page.mainPage.steps.CommonSteps.*;
import static test.BaseTest.isMobile;

public class FilmTicketsStep {

    //Заголовок блока "Билеты в кино"
    SelenideElement headerFilmTicketsBlock =  $("[class *='film-page-section-title']>[href *='afisha/new']");

    //Название фильма в карусели
    ElementsCollection nameFilmTickets =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    ElementsCollection yearAndGenreFilmTickets =  $$("[class *='captions']>[class *='subtitle']>span");

    //Ссылка на фильм
    ElementsCollection hrefFilmTickets =  $$("[class *='styles_captions__9Azea']");

    //Рейтинг фильма
    ElementsCollection ratingFilmTickets =  $$("[class *='ratingPosterNameplate__G2BsG']");

    //Кнопка вперед
    SelenideElement  forwardArrowTickets =  $("[class *='iconRightDir']");

    //Кнопка назад
    SelenideElement  backArrowTickets =  $("[class *='iconLeftDir']");

    ElementsCollection iconTickets = $$("[class *='styles_nameplate__Ei1aO']");

    //Ссылка билеты в кино у сниппета в карусели
    ElementsCollection  hrefIconTickets =  $$("[class *='styles_nameplate__Ei1aO']");

    //Текст "Билеты" в кино у сниппета в карусели
    ElementsCollection  textIconTickets =  $$("[class *='labelPlaceholder']+[class *='labelVisible']");

    //Маленькая иконка
    ElementsCollection  smallIconTickets =  $$("[class *='styles_icon__S5pZJ']");

    //Постер изоображение
    ElementsCollection posterImgTickets =  $$("[class *='posterLink']>[class *='poster']");

    //Весь блок Билеты в кино
    SelenideElement filmTicketsBlock = $(byId("today-in-cinema-block"));


    @И("проверяет, название блока Билеты в кино")
    public FilmTicketsStep проверяетНазваниеБлокаБилетыВКино() {
        nameBlock(headerFilmTicketsBlock, "Билеты в кино");
        return this;
    }

    @И("проверяет, что ссылка блока afisha")
    public FilmTicketsStep проверяетЧтоСсылкаБлокаAfisha() {
        headerFilmTicketsBlock.shouldBe(Condition.attribute("href", linkTicketsBlock));
        return this;
    }

    @И("проверяет, что у блока Билеты в кино стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public FilmTicketsStep проверяетЧтоУБлокаБилетыВКиноСтрелкаНазадОтсутствуетПослеНажатияСтрелкиВпередСтрелкаНазадПоявляется() {
        if (!isMobile()) {
            scroll(backArrowTickets, forwardArrowTickets);
        }
        else{
            System.out.println("Step assertIconFilmRegex ignored for mobile");
        }
        return this;
    }

    @И("проверяет, плашку Билеты в кино")
    public FilmTicketsStep проверяетПлашкуБилетыВКино() {
        if (!isMobile()) {
            for (int i = 0; i < iconTickets.size(); i++) {
                best2Scroll(iconTickets.get(i));
                iconTickets.get(i).shouldBe(Condition.visible);
//                assertHrefTicketsRegex(hrefIconTickets.get(i));
//                smallIconTickets.get(i).hover();
//                textIconTickets.get(i).shouldBe(Condition.visible);
                assertThat(iconTickets.get(i).getText()).as("Название на плашке не Билеты").isEqualTo("Билеты");
            }
        } else {
            System.out.println("Step assertIconFilmRegex ignored for mobile");
        }
        return this;
    }

    @И("проверяет, что у сниппета есть постер. Regex. Билеты в кино")
    public FilmTicketsStep проверяетЧтоУСниппетаЕстьПостерRegexБилетыВКино() {
        for (SelenideElement posterImgTicket : posterImgTickets) {
            posterImgTicket.isImage();
        }
        return this;
    }

    @И("проверяет, что рейтинг. Regex. Билеты в кино")
    public FilmTicketsStep проверяетЧтоРейтингRegexБилетыВКино() {
        for (SelenideElement ratingFilmTickets : ratingFilmTickets) {
            assertRatingRegex(ratingFilmTickets);
        }
        return this;
    }

    @И("проверяет, что год и жанр корректный. Билеты в кино")
    public FilmTicketsStep проверяетЧтоГодИЖанрКорректныйБилетыВКино() {
        for (SelenideElement yearAndGenreFilmTicket : yearAndGenreFilmTickets) {
            assertYearAndGenreRegex(yearAndGenreFilmTicket);
        }
        return this;
    }

    @И("проверяет, что ссылка корректна. Regex. Билеты в кино")
    public FilmTicketsStep проверяетЧтоСсылкаКорректнаRegexБилетыВКино() {
        for (SelenideElement hrefFilmTicket : hrefFilmTickets) {
            assertHrefRegex(hrefFilmTicket);
        }
        return this;
    }

    @И("проверяет, что название корректно. Regex. Билеты в кино")
    public FilmTicketsStep проверяетЧтоНазваниеКорректноRegexБилетыВКино() {
        for (SelenideElement nameFilmTicket : nameFilmTickets) {
            assertNameRegex(nameFilmTicket);
        }
        return this;
    }

    @То("скролит к блоку Билеты в кино")
    public FilmTicketsStep скролитКБлокуБилетыВКино() {
        bestScroll(filmTicketsBlock);
        headerFilmTicketsBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}
