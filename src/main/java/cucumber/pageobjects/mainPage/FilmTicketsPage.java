package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FilmTicketsPage extends AbstractPage {

    //Заголовок блока "Билеты в кино"
    @NameOfElement("Заголовок блока Билеты в кино")
    SelenideElement headerFilmTicketsBlock =  $("[class *='film-page-section-title']>[href *='afisha/new']");

    //Название фильма в карусели
    @NameOfElement("Название фильма в карусели")
    ElementsCollection nameFilmTickets =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    @NameOfElement("Жанр и год фильма")
    ElementsCollection yearAndGenreFilmTickets =  $$("[class *='captions']>[class *='subtitle']>span");

    //Ссылка на фильм
    @NameOfElement("Ссылка на фильм")
    ElementsCollection hrefFilmTickets =  $$("[class *='styles_captions__9Azea']");

    //Рейтинг фильма
    @NameOfElement("Рейтинг фильма")
    ElementsCollection ratingFilmTickets =  $$("[class *='ratingPosterNameplate__G2BsG']");

    //Кнопка вперед
    @NameOfElement("Стрелка вперед")
    SelenideElement  forwardArrowTickets =  $("[id ='today-in-cinema-block'] + div > section > div > [class *='carousel'] >[class *='iconRightDir']");

    //Кнопка назад
    @NameOfElement("Стрелка назад")
    SelenideElement  backArrowTickets =  $("[id ='today-in-cinema-block'] + div > section > div > [class *='carousel'] > [class *='iconLeftDir']");

    //Текст "Билеты" в кино у сниппета в карусели
    @NameOfElement("Плашка Билеты в кино")
    ElementsCollection  textIconTickets =  $$("[class *='labelPlaceholder']+[class *='labelVisible']");

    //Постер изоображение
    @NameOfElement("Постер у сниппета фильма")
    ElementsCollection posterImgTickets =  $$("[class *='posterLink']>[class *='poster']");

    //Весь блок Билеты в кино
    @NameOfElement("Билеты в кино")
    SelenideElement filmTicketsBlock = $(byId("today-in-cinema-block"));
}
