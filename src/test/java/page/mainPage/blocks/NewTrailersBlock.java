package page.mainPage.blocks;

import data.pattern.colourPattern;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.pattern.linkPattern.linkTrailerBlock;
import static org.assertj.core.api.Assertions.*;
import static page.mainPage.steps.CommonSteps.*;
import static page.mainPage.steps.CommonSteps.bestScroll;
import static test.BaseTest.isMobile;

public class NewTrailersBlock {

    //Название и ссылка трейлера
    ElementsCollection nameAndHrefTrailer = $$("[class *='title__vd']");

    //Год и жанр трейлера
    ElementsCollection yearAndGenreTrailer = $$("[class *='title__vd']+[class *='date']");

    //Стрелка назад
    SelenideElement backArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonLeft']");

    //Стрелка вперед
    SelenideElement forwardArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonRight']");

    //Оранжевая кнопка проигрывания видео
    ElementsCollection videoPlaybackTrailer = $$("[class *='newTrailer']");

    //Плеер с трейлером
    SelenideElement playerTrailer = $("[class *='discovery-trailers-wrapper']");

    //Плеер с трейлером Mobile
    SelenideElement playerTrailerMobile = $("#touch-trailer-modal");

    //Закрытие плеера с трейлером
    SelenideElement trailersCloser = $("[class *='discovery-trailers-closer']");

    //Закрытие плеера с трейлером Mobile
    SelenideElement trailersCloserMobile = $("[class *='closeButton']");

    //Заголовок блока
    SelenideElement headerTrailerBlock = $(byText("Новые трейлеры"));

    //Весь блок трейлеры
    SelenideElement trailersBlock = $(byId("new-trailers-block"));

    @Step
    public NewTrailersBlock scrollToTrailer() {
        bestScroll(trailersBlock);
        headerTrailerBlock.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return this;
    }

    @Step("Проверка, что название корректно. Regex")
    public NewTrailersBlock assertNameTrailerRegex() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));
            assertNameRegex(nameAndHrefTrailer.get(j));
        }
        return this;
    }

    @Step("Проверка, что ссылка корректна. Regex")
    public NewTrailersBlock assertHrefTrailerRegex() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));
            assertHrefRegex(nameAndHrefTrailer.get(j));
        }
        return this;
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public NewTrailersBlock assertYearAndGenreTrailerRegex() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));
            assertYearAndGenreRegex(yearAndGenreTrailer.get(j));
        }
        return this;
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public NewTrailersBlock scrollTrailer() {
        if (!isMobile()) {
            scroll(backArrowTrailer, forwardArrowTrailer);
        } else {
            System.out.println("Step scrollTrailer ignored for mobile");
        }
        return this;
    }

    @Step("Название блока")
    public NewTrailersBlock nameTrailerBlock() {
        nameBlock(headerTrailerBlock, "Новые трейлеры");
        return this;
    }

    @Step("Заголовок блока ведетна страницу https://www.kinopoisk.ru/video/")
    public NewTrailersBlock hrefTrailerBlock() {
        if (!isMobile()) {
            headerTrailerBlock.shouldBe(Condition.attribute("href", linkTrailerBlock));
        } else {
            System.out.println("Step hrefTrailerBlock ignored for mobile");
        }
        return this;
    }

    @Step("Плеер, по нажатию открывается плеер")
    public NewTrailersBlock playerTrailer() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));
            videoPlaybackTrailer.get(j).click();
            sleep(500);

            if (!isMobile()) {
                playerTrailer.shouldBe(Condition.visible);
                trailersCloser.click();
            } else {
                playerTrailerMobile.shouldBe(Condition.visible);
                trailersCloserMobile.click();
            }
        }
        return this;

    }

    @Step("Плеер. Цвет кнопки оранжевый")
    public NewTrailersBlock colourPlayerTrailer() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            bestScroll(nameAndHrefTrailer.get(j));
            String colour = videoPlaybackTrailer.get(j).getCssValue("background-color");
            assertThat(colour).as("Цвет кнопки проигрывания трейлера не оранжевый").isEqualTo(colourPattern.orangeColourPlayer());
        }
        return this;
    }
}


