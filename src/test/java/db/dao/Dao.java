package db.dao;

import data.model.Film;

import java.util.List;

public interface Dao {

    boolean insertFilm(Film film);
    boolean insertManyFilm(List<Film> list);
    boolean insertManyNameOfFilm(List<String> list, String SQL);

    int getFilmCount();
    Film getFilm();
    Film findFilmByName(String name);
    List<String> getNameOfFilm();

    boolean updateFilm(String name, String link);

    boolean deleteFilmByName(String name);
}
