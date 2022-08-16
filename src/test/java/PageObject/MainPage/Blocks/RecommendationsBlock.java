package PageObject.MainPage.Blocks;

import PageObject.MainPage.Steps.CommonSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RecommendationsBlock {

    //Название фильма в карусели
    ElementsCollection nameRecommend =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    ElementsCollection yearAndGenreRecommend =  $$("[class *='captions']>[class *='title']+[class *='subtitle']>span");

    //Ссылка на фильм
    ElementsCollection hrefRecommend =  $$("[class *='styles_captions__9Azea']");

    //Рейтинг фильма
    ElementsCollection ratingRecommend =  $$("[class *='styles_ratingPosterNameplate__hj_X7']");

    //Кнопка вперед
    SelenideElement  forwardArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] > [class *='carouselButtonRight']");

    //Кнопка назад
    SelenideElement  backArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] >[class *='carouselButtonLeft']");

    //Заголовок блока
    SelenideElement headerRecommendationsBlock =  $(byText("Рекомендации")).shouldBe(Condition.visible, Duration.ofMinutes(1));

    //Постер
    ElementsCollection posterRecommend =  $$("[class *='posterLink']>[class *='poster']");

    @Step("Проверка, что название корректно. Regex")
    public RecommendationsBlock assertNameRecommendRegex() {
        for (int i = 19; i < nameRecommend.size(); i++) {
            CommonSteps.assertNameRegex(nameRecommend.get(i));
        }
        return this;
    }

    @Step("Проверка, что ссылка корректна. Regex")
    public RecommendationsBlock assertHrefRecommendRegex() {
        for (int i = 19; i < hrefRecommend.size(); i++) {
            CommonSteps.assertHrefRegex(hrefRecommend.get(i));
        }
        return this;
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public RecommendationsBlock assertYearAndGenreRecommendRegex() {
        for (int i = 19; i < yearAndGenreRecommend.size(); i++) {
            CommonSteps.assertYearAndGenreRegex(yearAndGenreRecommend.get(i));
        }
        return this;
    }

    @Step("Проверка, что рейтинг корректный. Regex")
    public RecommendationsBlock assertRatingRecommendRegex() {
        for (int i = 19; i < ratingRecommend.size(); i++) {
            CommonSteps.assertRatingRegex(ratingRecommend.get(i));
        }
        return this;
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public RecommendationsBlock scrollRecommend(String platform) {
        switch (platform) {
            case "web":
                CommonSteps.scroll(backArrowRecommend, forwardArrowRecommend);
                break;

            case "mobile":
                System.out.println("Step scrollTickets ignored for mobile");
                break;
        }
        return this;
    }

    @Step("Название блока")
    public RecommendationsBlock nameRecommendationsBlock() {
        CommonSteps.nameBlock(headerRecommendationsBlock, "Рекомендации");
        return this;
    }

    @Step ("«Билеты в кино» ведет на страницу «/afisha/new/city/»")
    public RecommendationsBlock hrefRecommendationsBlock() {
        String linkRecommendationsBlock = "https://www.kinopoisk.ru/lists/movies/recommendation/?from_block=main_page";
        headerRecommendationsBlock.shouldBe(Condition.attribute("href", linkRecommendationsBlock));
        return this;
    }

    @Step ("У сниппета есть изоображение")
    public RecommendationsBlock imgRecommend() {
        for (int i = 19; i < nameRecommend.size(); i++) {
            posterRecommend.get(i).isImage();
        }
        return this;
    }
}
