package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewTrailerPage extends AbstractPage {
    //Название и ссылка трейлера
    @NameOfElement("Название трейлера")
    ElementsCollection nameAndHrefTrailer = $$("[class *='title__vd']");

    //Год и жанр трейлера
    @NameOfElement("Жанр и год трейлера")
    ElementsCollection yearAndGenreTrailer = $$("[class *='title__vd']+[class *='date']");

    //Стрелка назад
    @NameOfElement("Стрелка назад")
    SelenideElement backArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonLeft']");

    //Стрелка вперед
    @NameOfElement("Стрелка вперед")
    SelenideElement forwardArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonRight']");

    //Оранжевая кнопка проигрывания видео
    @NameOfElement("Оранжевая кнопка проигрывания видео")
    ElementsCollection videoPlaybackTrailer = $$("[class *='newTrailer']");

    //Плеер с трейлером
    @NameOfElement("Плеер с трейлером")
    SelenideElement playerTrailer = $("[class *='discovery-trailers-wrapper']");

    //Закрытие плеера с трейлером
    @NameOfElement("Закрытие плеера с трейлером")
    SelenideElement trailersCloser = $("[class *='discovery-trailers-closer']");

    //Заголовок блока
    @NameOfElement("Заголовок блока Новые трейлеры")
    SelenideElement headerTrailerBlock = $(byText("Новые трейлеры"));

    //Весь блок трейлеры
    @NameOfElement("Новые трейлеры")
    SelenideElement trailersBlock = $(byId("new-trailers-block"));

}
