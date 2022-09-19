package test.mainPageTest;

import page.mainPage.blocks.NewTrailersBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;

public class NewTrailerTest extends BaseTest {

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
                .hrefTrailerBlock();
    }

    @Test
    @Description("Проигрывание трейлера")
    public void checkPlayerTrailerBlock() {
        page(NewTrailersBlock.class)
                .playerTrailer();
    }

    @Test
    @Description("Скролл сниппетов")
    public void checkScroll() {
        page(NewTrailersBlock.class)
                .scrollTrailer();
    }
}
