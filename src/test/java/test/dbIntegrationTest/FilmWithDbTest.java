package test.dbIntegrationTest;

import page.mainPage.blocks.FilmForDbBlock;
import db.services.DbInteraction;
import io.qameta.allure.Description;
import data.model.Film;
import test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilmWithDbTest {

    private DbInteraction dbInteraction = new DbInteraction();

    @BeforeMethod
    public void openPage() {
        BaseTest.baseOpenPage("web",0);
    }

    @Test
    @Description("Тест с интеграцией DB, добавление одного фильма")
    public void checkDbInteraction(){
        FilmForDbBlock filmTicketsBlock = new FilmForDbBlock();
        Film addFilmToDb = filmTicketsBlock.getFilmList();
        dbInteraction.publishInsertFilm(addFilmToDb);
    }
}
