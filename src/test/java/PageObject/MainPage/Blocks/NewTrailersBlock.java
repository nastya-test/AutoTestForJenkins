package PageObject.MainPage.Blocks;

import PageObject.MainPage.Steps.CommonSteps;
import PageObject.Data.colourPattern;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;

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
    SelenideElement headerTrailerBlock = $(byText("Новые трейлеры")).shouldBe(Condition.visible, Duration.ofMinutes(1));

    @Step("Проверка, что название корректно. Regex")
    public NewTrailersBlock assertNameTrailerRegex() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
                nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
                sleep(500);
            CommonSteps.assertNameRegex(nameAndHrefTrailer.get(j));
        }
        return this;
    }

    @Step("Проверка, что ссылка корректна. Regex")
    public NewTrailersBlock assertHrefTrailerRegex() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
                nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            CommonSteps.assertHrefRegex(nameAndHrefTrailer.get(j));
        }
        return this;
    }

    @Step("Проверка, что год и жанр корректный. Regex")
    public NewTrailersBlock assertYearAndGenreTrailerRegex() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
                nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            CommonSteps.assertYearAndGenreRegex(yearAndGenreTrailer.get(j));
        }
        return this;
    }

    @Step("Стрелки прокрутки. Стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public NewTrailersBlock scrollTrailer(String platform) {
        switch (platform) {
            case "web":
                CommonSteps.scroll(backArrowTrailer, forwardArrowTrailer);
                break;

            case "mobile":
                System.out.println("Step scrollTrailer ignored for mobile");
                break;
        }
        return this;
    }

    @Step("Название блока")
    public NewTrailersBlock nameTrailerBlock() {
        CommonSteps.nameBlock(headerTrailerBlock, "Новые трейлеры");
        return this;
    }

    @Step("Заголовок блока ведетна страницу https://www.kinopoisk.ru/video/")
    public NewTrailersBlock hrefTrailerBlock(String platform) {
        switch (platform) {
            case "web":
                String linkRecommendBlock = "https://www.kinopoisk.ru/video/";
                headerTrailerBlock.shouldBe(Condition.attribute("href", linkRecommendBlock));
                break;

            case "mobile":
                System.out.println("Step hrefTrailerBlock ignored for mobile");
                break;
        }
        return this;
    }

    @Step("Плеер, по нажатию открывается плеер")
    public NewTrailersBlock playerTrailer(String platform) {

        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");

            videoPlaybackTrailer.get(j).click();
            sleep(500);

            switch (platform) {
                case "web":
                    playerTrailer.shouldBe(Condition.visible);
                    trailersCloser.click();
                    break;

                case "mobile":
                    playerTrailerMobile.shouldBe(Condition.visible);
                    trailersCloserMobile.click();
                    break;
            }
        }
        return this;
    }
    @Step("Плеер. Цвет кнопки оранжевый")
    public NewTrailersBlock colourPlayerTrailer() {

        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");

            String colour = videoPlaybackTrailer.get(j).getCssValue("background-color");
            assertThat(colour).as("Цвет кнопки проигрывания трейлера не оранжевый").isEqualTo(colourPattern.orangeColour());

        }
        return this;
    }

}


