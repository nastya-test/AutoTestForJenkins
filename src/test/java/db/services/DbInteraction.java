package db.services;

import db.dao.Dao;
import db.dao.FilmDao;
import data.model.Film;
import java.util.List;

public class DbInteraction {
    private Dao dao = new FilmDao();

    public void publishTrailerInfo(List<Film> film) {
        dao.insertManyFilm(film);
    }

    public void publishInsertFilm(Film film) {
        dao.insertFilm(film);
    }
}
