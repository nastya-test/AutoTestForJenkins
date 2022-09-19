package test.mainPageTest;

import page.mainPage.blocks.FilmTicketsBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;

public class FilmTicketsTest extends BaseTest {

    @Test
    @Description("Regex. Название, год и жанр, ссылка, рейтинг. + у сниппета есть постер")
    public void checkRegexFilmTickets() {
        page(FilmTicketsBlock.class)
                .imgFilmTickets()
                .assertNameFilmTicketsRegex()
                .assertYearAndGenreFilmTicketsRegex()
                .assertHrefFilmTicketsRegex()
                .assertRatingFilmTicketsRegex();
    }

    @Test
    @Description("Название блока и ссылка")
    public void checkHeaderFilmTicketsBlock() {
        page(FilmTicketsBlock.class)
                .nameTicketsBlock()
                .hrefTicketsBlock();
    }

    @Test
    @Description("Плашка с билетами")
    public void checkLabelTickets() {
        page(FilmTicketsBlock.class)
                .assertIconFilmRegex();
    }

    @Test
    @Description("Скролл сниппетов")
    public void checkScrollTickets() {
        page(FilmTicketsBlock.class)
                .scrollTickets();
    }


}
