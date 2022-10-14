package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FilmTicketsPage extends AbstractPage {

    @NameOfElement("Заголовок блока Билеты в кино")
    SelenideElement headerFilmTicketsBlock =  $("[class *='film-page-section-title']>[href *='afisha/new']");

    @NameOfElement("Название фильма в карусели")
    ElementsCollection nameFilmTickets =  $$("[class *='captions']>[class *='title']> span > span");

    @NameOfElement("Жанр и год фильма")
    ElementsCollection yearAndGenreFilmTickets =  $$("[class *='captions']>[class *='subtitle']>span");

    @NameOfElement("Ссылка на фильм")
    ElementsCollection hrefFilmTickets =  $$("[class *='styles_captions__9Azea']");

    @NameOfElement("Рейтинг фильма")
    ElementsCollection ratingFilmTickets =  $$("[class *='ratingPosterNameplate__G2BsG']");

    @NameOfElement("Стрелка вперед")
    SelenideElement  forwardArrowTickets =  $("[id ='today-in-cinema-block'] + div > section > div > [class *='carousel'] >[class *='iconRightDir']");

    @NameOfElement("Стрелка назад")
    SelenideElement  backArrowTickets =  $("[id ='today-in-cinema-block'] + div > section > div > [class *='carousel'] > [class *='iconLeftDir']");

    @NameOfElement("Плашка Билеты в кино")
    ElementsCollection  textIconTickets =  $$("[class *='labelPlaceholder']+[class *='labelVisible']");

    @NameOfElement("Постер у сниппета фильма")
    ElementsCollection posterImgTickets =  $$("[class *='posterLink']>[class *='poster']");

    @NameOfElement("Билеты в кино")
    SelenideElement filmTicketsBlock = $(byId("today-in-cinema-block"));
}
