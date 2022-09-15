package test.mainPageTest;

import page.mainPage.blocks.FilmTicketsBlock;
import io.qameta.allure.Description;
import test.BaseTest;
import config.ConfProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilmTicketsTest {

    @BeforeMethod
    public void openPage() {
       BaseTest.baseOpenPage(ConfProperties.getProperty("platform"),0);
    }

    @Test
    @Description("Regex. Название, год и жанр, ссылка, рейтинг. + у сниппета есть постер")
    public void checkRegexFilmTickets() {
        FilmTicketsBlock filmTicketsBlock = new FilmTicketsBlock();
        filmTicketsBlock
                .imgFilmTickets()
                .assertNameFilmTicketsRegex()
                .assertYearAndGenreFilmTicketsRegex()
                .assertHrefFilmTicketsRegex()
                .assertRatingFilmTicketsRegex();
    }

    @Test
    @Description("Название блока и ссылка")
    public void checkHeaderFilmTicketsBlock() {
        FilmTicketsBlock filmTicketsBlock = new FilmTicketsBlock();
        filmTicketsBlock
                .nameTicketsBlock()
                .hrefTicketsBlock();
    }

    @Test
    @Description("Плашка с билетами")
    public void checkLabelTickets() {
        FilmTicketsBlock filmTicketsBlock = new FilmTicketsBlock();
        filmTicketsBlock
                .assertIconFilmRegex(ConfProperties.getProperty("platform"));
    }

    @Test
    @Description("Скролл сниппетов")
    public void checkScrollTickets() {
        FilmTicketsBlock filmTicketsBlock = new FilmTicketsBlock();
            filmTicketsBlock
                    .scrollTickets(ConfProperties.getProperty("platform"));
        }


}
