package cucumber.pageobjects.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.pageobjects.AbstractPage;
import cucumber.pageobjects.NameOfElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RecommendationPage extends AbstractPage {
    //Название фильма в карусели
    @NameOfElement("Название фильма в карусели")
    ElementsCollection nameRecommend =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    @NameOfElement("Жанр и год фильма")
    ElementsCollection yearAndGenreRecommend =  $$("[class *='captions']>[class *='title']+[class *='subtitle']>span");

    //Ссылка на фильм
    @NameOfElement("Ссылка на фильм")
    ElementsCollection hrefRecommend =  $$("[class *='styles_captions__9Azea']");

    //Рейтинг фильма
    @NameOfElement("Рейтинг фильма")
    ElementsCollection ratingRecommend =  $$("[class *='styles_ratingPosterNameplate__hj_X7']");

    //Кнопка вперед
    @NameOfElement("Стрелка вперед")
    SelenideElement forwardArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] > [class *='carouselButtonRight']");

    //Кнопка назад
    @NameOfElement("Стрелка назад")
    SelenideElement  backArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] >[class *='carouselButtonLeft']");

    //Заголовок блока
    @NameOfElement("Заголовок блока Рекомендации")
    SelenideElement headerRecommendationsBlock =  $(byText("Рекомендации"));

    //Постер
    @NameOfElement("Постер у сниппета фильма")
    ElementsCollection posterRecommend =  $$("[class *='posterLink']>[class *='poster']");

    //Весь блок Рекомендации
    @NameOfElement("Рекомендации")
    SelenideElement recommendationsBlock = $(byId("recommendations-block"));

}
