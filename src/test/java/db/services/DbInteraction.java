package db.services;

import db.dao.Dao;
import db.dao.FilmDao;
import data.model.Film;
import java.util.List;

public class DbInteraction {

    private Dao dao = new FilmDao();

    public void InsertManyFilm(List<Film> film) {
        dao.insertManyFilm(film);
    }

    public void InsertFilm(Film film) {
        dao.insertFilm(film);
    }

    public void getFilm() {
        dao.getFilm();
    }

    public void getFilmCount() {
        dao.getFilmCount();
    }

    public void findFilmByName(String name) {
        dao.findFilmByName(name);
    }

    public void updateFilm(String name, String link) {
        dao.updateFilm(name, link);
    }

    public void deleteFilmByName(String name) {
        dao.deleteFilmByName(name);
    }

    public List<String> getNameOfFilm() {return dao.getNameOfFilm();}
}
