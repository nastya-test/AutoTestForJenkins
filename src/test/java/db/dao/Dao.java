package db.dao;

import model.Film;

import java.util.List;

public interface Dao {
    boolean insertFilm(Film film);
    boolean insertManyFilm(List<Film> list);
    int getFilmCount();
    Film getFilm();
    Film findFilmByName(String name);
    boolean updateFilm(String name, String link);
    boolean deleteFilmByName(String name);


}
