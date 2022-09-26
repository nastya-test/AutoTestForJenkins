package page.cucumberStepDefinition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.То;
import page.mainPage.steps.CommonSteps;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TrailerStep {
    //Название и ссылка трейлера
    ElementsCollection nameAndHrefTrailer = $$("[class *='title__vd']");

    //Год и жанр трейлера
    ElementsCollection yearAndGenreTrailer = $$("[class *='title__vd']+[class *='date']");

    //Оранжевая кнопка проигрывания видео
    ElementsCollection videoPlaybackTrailer = $$("[class *='newTrailer']");

    //Плеер с трейлером
    SelenideElement playerTrailer = $("[class *='discovery-trailers-wrapper']");

    //Закрытие плеера с трейлером
    SelenideElement trailersCloser = $("[class *='discovery-trailers-closer']");

    //Заголовок блока
    SelenideElement headerTrailerBlock = $(byText("Новые трейлеры")).shouldBe(Condition.visible, Duration.ofMinutes(1));

    //Стрелка назад
    SelenideElement backArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonLeft']");

    //Стрелка вперед
    SelenideElement forwardArrowTrailer = $("[id ='new-trailers-block'] + div > div > [class *='carousel'] > [class *='carouselButtonRight']");

    @То("проверяет, название блока Новые трейлеры")
    public void проверяет_название_блока_билеты_в_кино() {
        CommonSteps.nameBlock(headerTrailerBlock, "Новые трейлеры");
    }

    @То("проверяет, что  по нажатию на кнопку открывается плеер")
    public void проверяет_что_по_нажатию_на_кнопку_открывается_плеер() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            videoPlaybackTrailer.get(j).click();
            sleep(500);
            playerTrailer.shouldBe(Condition.visible);
            trailersCloser.click();
        }
    }
    @То("проверяет, что ссылка блока video")
    public void проверяет_что_ссылка_блока_video() {
        String linkRecommendBlock = "https://www.kinopoisk.ru/video/";
        headerTrailerBlock.shouldBe(Condition.attribute("href", linkRecommendBlock));
    }

    @То("проверяет, что название корректно. Regex. Трейлеры")
    public void проверяет_что_название_корректно_regex_трейлеры() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            sleep(500);
            CommonSteps.assertNameRegex(nameAndHrefTrailer.get(j));
        }
    }

    @То("проверяет, что ссылка корректна. Regex. Трейлеры")
    public void проверяет_что_ссылка_корректна_regex_трейлеры() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            CommonSteps.assertHrefRegex(nameAndHrefTrailer.get(j));
        }
    }

    @То("проверяет, что год и жанр корректный. Regex. Трейлеры")
    public void проверяет_что_год_и_жанр_корректный_regex_трейлеры() {
        for (int j = 0; j < nameAndHrefTrailer.size(); j++) {
            nameAndHrefTrailer.get(j).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"end\"}");
            CommonSteps.assertYearAndGenreRegex(yearAndGenreTrailer.get(j));
        }
    }

    @То("проверяет, что у блока Новые трейлеры стрелка назад отсутствует, после нажатия стрелки вперед, стрелка назад появляется")
    public void проверяет_что_у_блока_новые_трейлеры_стрелка_назад_отсутствует_после_нажатия_стрелки_вперед_стрелка_назад_появляется() {
        CommonSteps.scroll(backArrowTrailer, forwardArrowTrailer);
    }

    @То("скролит к блоку Новые трейлеры")
    public void скролит_к_блоку_новые_трейлеры() {
    }
}
