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

    @NameOfElement("Название фильма в карусели")
    public ElementsCollection nameRecommend =  $$("[class *='captions']>[class *='title']> span > span");

    @NameOfElement("Жанр и год фильма")
    public ElementsCollection yearAndGenreRecommend =  $$("[class *='captions']>[class *='title']+[class *='subtitle']>span");

    @NameOfElement("Ссылка на фильм")
    public ElementsCollection hrefRecommend =  $$("[class *='styles_captions__9Azea']");

    @NameOfElement("Рейтинг фильма")
    public ElementsCollection ratingRecommend =  $$("[class *='styles_ratingPosterNameplate__hj_X7']");

    @NameOfElement("Стрелка вперед")
    public SelenideElement forwardArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] > [class *='carouselButtonRight']");

    @NameOfElement("Стрелка назад")
    public SelenideElement  backArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] >[class *='carouselButtonLeft']");

    @NameOfElement("Заголовок блока Рекомендации")
    public SelenideElement headerRecommendationsBlock =  $(byText("Рекомендации"));

    @NameOfElement("Постер у сниппета фильма")
    public ElementsCollection posterRecommend =  $$("[class *='posterLink']>[class *='poster']");

    @NameOfElement("Рекомендации")
    public SelenideElement recommendationsBlock = $(byId("recommendations-block"));

}
