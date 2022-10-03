package db.dao;

import data.model.Film;

import java.util.List;

public interface Dao {
    boolean insertFilm(Film film);
    boolean insertManyFilm(List<Film> list);
    int getFilmCount();
    Film getFilm();
    Film findFilmByName(String name);
    boolean updateFilm(String name, String link);
    List<String> getNameOfFilm();
    boolean deleteFilmByName(String name);
    boolean insertManyNameOfFilm(List<String> list, String SQL);
}
