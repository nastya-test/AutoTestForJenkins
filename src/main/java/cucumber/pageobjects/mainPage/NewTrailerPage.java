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
    @NameOfElement("Название трейлера")
    ElementsCollection nameAndHrefTrailer = $$("[class *='title__vd']");

    @NameOfElement("Жанр и год трейлера")
    ElementsCollection yearAndGenreTrailer = $$("[class *='title__vd']+[class *='date']");

    @NameOfElement("Стрелка назад")
    SelenideElement backArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonLeft']");

    @NameOfElement("Стрелка вперед")
    SelenideElement forwardArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonRight']");

    @NameOfElement("Оранжевая кнопка проигрывания видео")
    ElementsCollection videoPlaybackTrailer = $$("[class *='newTrailer']");

    @NameOfElement("Плеер с трейлером")
    SelenideElement playerTrailer = $("[class *='discovery-trailers-wrapper']");

    @NameOfElement("Закрытие плеера с трейлером")
    SelenideElement trailersCloser = $("[class *='discovery-trailers-closer']");

    @NameOfElement("Заголовок блока Новые трейлеры")
    SelenideElement headerTrailerBlock = $(byText("Новые трейлеры"));

    @NameOfElement("Новые трейлеры")
    SelenideElement trailersBlock = $(byId("new-trailers-block"));

}
