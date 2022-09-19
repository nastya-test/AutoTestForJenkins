package page.mainPage.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.Constants.linkTicketsBlock;
import static org.assertj.core.api.Assertions.*;
import static page.mainPage.steps.CommonSteps.*;

public class FilmTicketsBlock {

    //Заголовок блока "Билеты в кино"
    SelenideElement headerFilmTicketsBlock =  $("[class *='film-page-section-title']>[href *='afisha/new']");

    //Название фильма в карусели
    ElementsCollection nameFilmTickets =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    ElementsCollection yearAndGenreFilmTickets =  $$("[class *='captions']>[class *='subtitle']>span");

    //Ссылка на фильм
    ElementsCollection hrefFilmTickets =  $$("[class *='captions']");

    //Рейтинг фильма
    ElementsCollection ratingFilmTickets =  $$("[class *='ratingPosterNameplate__G2BsG']");

    //Кнопка вперед
    SelenideElement  forwardArrowTickets =  $("[class *='iconRightDir']");

    //Кнопка назад
    SelenideElement  backArrowTickets =  $("[class *='iconLeftDir']");

    //Ссылка билеты в кино у сниппета в карусели
    ElementsCollection  hrefIconTickets =  $$("[class *='styles_nameplate__Ei1aO']");

    //Текст "Билеты" в кино у сниппета в карусели
    ElementsCollection  textIconTickets =  $$("[class *='labelPlaceholder']+[class *='labelVisible']");

    //Маленькая иконка
    ElementsCollection  smallIconTickets =  $$("[class *='styles_icon__S5pZJ']");

    //Постер изоображение
    ElementsCollection posterImgTickets =  $$("[class *='posterLink']>[class *='poster']");

    @Step("Проверка, что название корректно. Regex")
    public FilmTicketsBlock assertNameFilmTicketsRegex() {
        for (SelenideElement nameFilmTicket : nameFilmTickets) {
            assertNameRegex(nameFilmTicket);
        }
        return this;
    }

    @Step("Проверка, что ссылка корректна. Regex")
    public FilmTicketsBlock assertHrefFilmTicketsRegex() {
        for (SelenideElement hrefFilmTicket : hrefFilmTickets) {
            assertHrefRegex(hrefFilmTicket);
        }
        return this;
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public FilmTicketsBlock assertYearAndGenreFilmTicketsRegex() {
        for (SelenideElement yearAndGenreFilmTicket : yearAndGenreFilmTickets) {
            assertYearAndGenreRegex(yearAndGenreFilmTicket);
        }
        return this;
    }

    @Step("Проверка, что рейтинг корректный. Regex")
    public FilmTicketsBlock assertRatingFilmTicketsRegex() {
        for (SelenideElement ratingFilmTickets : ratingFilmTickets) {
            assertRatingRegex(ratingFilmTickets);
        }
        return this;
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется. +  Появление нового сниппета")
    public FilmTicketsBlock scrollTickets(String platform) {
        switch (platform) {
            case "web":
                scroll(backArrowTickets, forwardArrowTickets);
                break;

            case "mobile":
                System.out.println("Step scrollTickets ignored for mobile");
                break;
        }
        return this;
    }

    @Step("Название блока")
    public FilmTicketsBlock nameTicketsBlock() {
        nameBlock(headerFilmTicketsBlock, "Билеты в кино");
        return this;
    }

    @Step ("«Билеты в кино» ведет на страницу «/afisha/new/city/»")
    public FilmTicketsBlock hrefTicketsBlock() {
        headerFilmTicketsBlock.shouldBe(Condition.attribute("href", linkTicketsBlock));
        return this;
    }

    @Step("Плашка с билетами, корректность ссылки, что при наведении мышкой на плашку появляется большая плашка с надписью Билеты")
    public FilmTicketsBlock assertIconFilmRegex(String platform) {
        switch (platform) {
            case "web":
                for (int i = 0; i < hrefFilmTickets.size(); i++) {
                    smallIconTickets.get(i).shouldBe(Condition.visible);
                    assertHrefTicketsRegex(hrefIconTickets.get(i));
                    smallIconTickets.get(i).hover();
                    textIconTickets.get(i).shouldBe(Condition.visible);
                    assertThat(textIconTickets.get(i).getText()).as("Название на плашке не Билеты").isEqualTo("Билеты");
                }
                break;

            case "mobile":
                System.out.println("Step assertIconFilmRegex ignored for mobile");
                break;
        }
            return this;

    }

    @Step ("У сниппета есть изоображение")
    public FilmTicketsBlock imgFilmTickets() {
        for (SelenideElement posterImgTicket : posterImgTickets) {
            posterImgTicket.isImage();
        }
        return this;
    }

}
