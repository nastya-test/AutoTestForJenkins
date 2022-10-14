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
    public ElementsCollection nameAndHrefTrailer = $$("[class *='title__vd']");

    @NameOfElement("Жанр и год трейлера")
    public ElementsCollection yearAndGenreTrailer = $$("[class *='title__vd']+[class *='date']");

    @NameOfElement("Стрелка назад")
    public SelenideElement backArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonLeft']");

    @NameOfElement("Стрелка вперед")
    public SelenideElement forwardArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonRight']");

    @NameOfElement("Оранжевая кнопка проигрывания видео")
    public ElementsCollection videoPlaybackTrailer = $$("[class *='newTrailer']");

    @NameOfElement("Плеер с трейлером")
    public SelenideElement playerTrailer = $("[class *='discovery-trailers-wrapper']");

    @NameOfElement("Закрытие плеера с трейлером")
    public SelenideElement trailersCloser = $("[class *='discovery-trailers-closer']");

    @NameOfElement("Заголовок блока Новые трейлеры")
    public SelenideElement headerTrailerBlock = $(byText("Новые трейлеры"));

    @NameOfElement("Новые трейлеры")
    public SelenideElement trailersBlock = $(byId("new-trailers-block"));

}
