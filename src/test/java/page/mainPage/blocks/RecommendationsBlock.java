package page.mainPage.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.Constants.linkRecommendationsBlock;
import static page.mainPage.steps.CommonSteps.*;
import static test.BaseTest.isMobile;

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
    SelenideElement headerRecommendationsBlock =  $(byText("Рекомендации"));

    //Постер
    ElementsCollection posterRecommend =  $$("[class *='posterLink']>[class *='poster']");

    //Весь блок Рекомендации
    SelenideElement recommendationsBlock = $(byId("recommendations-block"));

    @Step
    public RecommendationsBlock scrollToRecommendationsBlock() {
        bestScroll(recommendationsBlock);
        headerRecommendationsBlock.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return this;
    }

    @Step("Проверка, что название корректно. Regex")
    public RecommendationsBlock assertNameRecommendRegex() {
        for (int i = 19; i < nameRecommend.size(); i++) {
            assertNameRegex(nameRecommend.get(i));
        }
        return this;
    }

    @Step("Проверка, что ссылка корректна. Regex")
    public RecommendationsBlock assertHrefRecommendRegex() {
        for (int i = 19; i < hrefRecommend.size(); i++) {
            assertHrefRegex(hrefRecommend.get(i));
        }
        return this;
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public RecommendationsBlock assertYearAndGenreRecommendRegex() {
        for (int i = 19; i < yearAndGenreRecommend.size(); i++) {
            assertYearAndGenreRegex(yearAndGenreRecommend.get(i));
        }
        return this;
    }

    @Step("Проверка, что рейтинг корректный. Regex")
    public RecommendationsBlock assertRatingRecommendRegex() {
        for (int i = 19; i < ratingRecommend.size(); i++) {
            assertRatingRegex(ratingRecommend.get(i));
        }
        return this;
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public RecommendationsBlock scrollRecommend() {
        if (!isMobile()) {
            scroll(backArrowRecommend, forwardArrowRecommend);
        } else {
            System.out.println("Step scrollRecommend ignored for mobile");
        }
        return this;
    }

    @Step("Название блока")
    public RecommendationsBlock nameRecommendationsBlock() {
        nameBlock(headerRecommendationsBlock, "Рекомендации");
        return this;
    }

    @Step ("«Билеты в кино» ведет на страницу «/afisha/new/city/»")
    public RecommendationsBlock hrefRecommendationsBlock() {
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
