package test.mainPageTest;

import page.mainPage.blocks.NewTrailersBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;

public class NewTrailerTest {

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),8);
    }

    @Test
    @Description("Regex. Название, год и жанр, ссылка")
    public void checkRegexNewTrailer(){
        page(NewTrailersBlock.class)
                .assertNameTrailerRegex()
                .assertYearAndGenreTrailerRegex()
                .assertHrefTrailerRegex();
    }

    @Test
    @Description("Название блока и ссылка")
    public void checkHeaderNewTrailerBlock() {
        page(NewTrailersBlock.class)
                .nameTrailerBlock()
                .hrefTrailerBlock(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("Проигрывание трейлера")
    public void checkPlayerTrailerBlock() {
        page(NewTrailersBlock.class)
                .playerTrailer(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("Скролл сниппетов")
    public void checkScroll() {
        page(NewTrailersBlock.class)
                .scrollTrailer(ConfProperties.getProperty("platform"));
    }
}
