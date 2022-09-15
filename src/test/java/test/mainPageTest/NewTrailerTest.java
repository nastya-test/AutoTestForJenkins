package test.mainPageTest;

import page.mainPage.blocks.NewTrailersBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTrailerTest {

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),8);
    }

    @Test
    @Description("Regex. Название, год и жанр, ссылка")
    public void checkRegexNewTrailer(){
        NewTrailersBlock newTrailersBlock = new NewTrailersBlock();
        newTrailersBlock
                .assertNameTrailerRegex()
                .assertYearAndGenreTrailerRegex()
                .assertHrefTrailerRegex();
    }

    @Test
    @Description("Название блока и ссылка")
    public void checkHeaderNewTrailerBlock() {
        NewTrailersBlock newTrailersBlock = new NewTrailersBlock();
        newTrailersBlock
                .nameTrailerBlock()
                .hrefTrailerBlock(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("Проигрывание трейлера")
    public void checkPlayerTrailerBlock() {
        NewTrailersBlock newTrailersBlock = new NewTrailersBlock();
        newTrailersBlock
                .playerTrailer(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("Скролл сниппетов")
    public void checkScroll() {
        NewTrailersBlock newTrailersBlock = new NewTrailersBlock();
        newTrailersBlock
                .scrollTrailer(ConfProperties.getProperty("platform"));
    }
}
