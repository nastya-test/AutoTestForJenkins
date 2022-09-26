package page.cucumberStepDefinition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static data.Constants.linkRecommendationsBlock;
import static data.Constants.linkTicketsBlock;
import static page.mainPage.steps.CommonSteps.*;
import static test.BaseTest.isMobile;

public class RecommendationStep {
    //Название фильма в карусели
    ElementsCollection nameRecommend =  $$("[class *='captions']>[class *='title']> span > span");

    //Жанр и год фильма
    ElementsCollection yearAndGenreRecommend =  $$("[class *='captions']>[class *='title']+[class *='subtitle']>span");

    //Ссылка на фильм
    ElementsCollection hrefRecommend =  $$("[class *='styles_captions__9Azea']");

    //Рейтинг фильма
    ElementsCollection ratingRecommend =  $$("[class *='styles_ratingPosterNameplate__hj_X7']");

    //Кнопка вперед
    SelenideElement forwardArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] > [class *='carouselButtonRight']");

    //Кнопка назад
    SelenideElement  backArrowRecommend =  $("[id ='recommendations-block'] + div > [class *='blockClassName'] > [class *='carousel'] >[class *='carouselButtonLeft']");

    //Заголовок блока
    SelenideElement headerRecommendationsBlock =  $(byText("Рекомендации"));

    //Постер
    ElementsCollection posterRecommend =  $$("[class *='posterLink']>[class *='poster']");

    //Весь блок Рекомендации
    SelenideElement recommendationsBlock = $(byId("recommendations-block"));

    @И("проверяет, что ссылка блока recommendation")
    public RecommendationStep проверяетЧтоСсылкаБлокаRecommendation() {
        headerRecommendationsBlock.shouldBe(Condition.attribute("href", linkRecommendationsBlock));
        return this;
    }


    @И("проверяет, название блока Рекомендации")
    public RecommendationStep проверяетНазваниеБлокаРекомендации() {
        nameBlock(headerRecommendationsBlock, "Рекомендации");
        return this;
    }

    @И("проверяет, что у сниппета есть постер. Regex. Рекомендации")
    public RecommendationStep проверяетЧтоУСниппетаЕстьПостерRegexРекомендации() {
        for (int i = 19; i < nameRecommend.size(); i++) {
            posterRecommend.get(i).isImage();
        }
        return this;
    }

    @И("проверяет, что рейтинг. Regex. Рекомендации")
    public RecommendationStep проверяетЧтоРейтингRegexРекомендации() {
        for (int i = 19; i < ratingRecommend.size(); i++) {
            assertRatingRegex(ratingRecommend.get(i));
        }
        return this;
    }

    @И("проверяет, что год и жанр корректный. Regex. Рекомендации")
    public RecommendationStep проверяетЧтоГодИЖанрКорректныйRegexРекомендации() {
        for (int i = 19; i < yearAndGenreRecommend.size(); i++) {
            assertYearAndGenreRegex(yearAndGenreRecommend.get(i));
        }
        return this;
    }

    @И("проверяет, что ссылка корректна. Regex. Рекомендации")
    public RecommendationStep проверяетЧтоСсылкаКорректнаRegexРекомендации() {
        for (int i = 19; i < hrefRecommend.size(); i++) {
            assertHrefRegex(hrefRecommend.get(i));
        }
        return this;
    }

    @И("проверяет, что название корректно. Regex. Рекомендации")
    public RecommendationStep проверяетЧтоНазваниеКорректноRegexРекомендации() {
        for (int i = 19; i < nameRecommend.size(); i++) {
            assertNameRegex(nameRecommend.get(i));
        }
        return this;
    }

    @И("проверяет, что у блока Рекомендации стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public RecommendationStep проверяетЧтоУБлокаРекомендацииСтрелкаНазадОтсутствуетПослеНажатияСтрелкиВпередСтрелкаНазадПоявляется() {
        if (!isMobile()) {
            scroll(backArrowRecommend, forwardArrowRecommend);
        } else {
            System.out.println("Step scrollRecommend ignored for mobile");
        }
        return this;
    }

    @То("скролит к блоку Рекомендации")
    public RecommendationStep скролитКБлокуРекомендации() {
        bestScroll(recommendationsBlock);
        headerRecommendationsBlock.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}
