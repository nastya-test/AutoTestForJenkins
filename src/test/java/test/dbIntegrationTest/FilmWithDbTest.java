package test.dbIntegrationTest;

import page.pageForDb.FilmForDbBlock;
import db.services.DbInteraction;
import io.qameta.allure.Description;
import data.model.Film;
import test.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class FilmWithDbTest extends BaseTest{

    private DbInteraction dbInteraction = new DbInteraction();

    @Test
    @Description("Добавление в DB фильмов из блока Новые трейлеры, у которых жанр и год не соответсвуют регулярному выраженю")
    public void checkDbInsertManyFilm(){
        FilmForDbBlock filmForDbBlock = new FilmForDbBlock();
        List<Film> addFilmToDb = filmForDbBlock.assertManyFilm();
        dbInteraction.InsertManyFilm(addFilmToDb);
    }

    @Test
    @Description("Добавление в DB одного фильма с баннера")
    public void checkDbInsertFilm(){
        FilmForDbBlock filmForDbBlock = new FilmForDbBlock();
        Film addFilmToDb = filmForDbBlock.assertFilm();
        dbInteraction.InsertFilm(addFilmToDb);
    }

    @Test
    @Description("Сравнение фильмов в бд и на сайте")
    public void checkCompareFilm(){
        FilmForDbBlock filmForDbBlock = new FilmForDbBlock();
        filmForDbBlock.compareNameOfFilms();
    }

}
