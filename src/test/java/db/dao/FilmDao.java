package db.dao;

import db.connection.JdbcConnection;
import data.model.Film;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDao implements Dao{

    JdbcConnection jdbcConnection = new JdbcConnection();
    int affectedRows = 0;
    int count = 0;
    boolean success = false;

    /*Проверка внесения изменений*/
    private boolean assertAffectedRows(PreparedStatement pstmt) throws SQLException {
        affectedRows = pstmt.executeUpdate();
        if (affectedRows>0){
            success=true;
            System.out.println("Успешно выполнено");
        }
        return success;
    }

    /*Вывод сообщения при исключении*/
    private void getSqlExceptionMessage(SQLException ex)  {
        System.out.println(ex.getMessage());
    }

    /*Конвертация строки таблицы в модель Film*/
    private Film convertFilm(ResultSet rs) throws SQLException {
        Film film = new Film();
        film.setName(rs.getString("name"));
        film.setLink(rs.getString("link"));
        film.setYearAndGenre(rs.getString("yearandgenre"));
        return film;
    }

    /*Пробег по всем строкам таблицы и конвертация их в набор моделей Film*/
    private Film displayFilm(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(convertFilm(rs));
            return convertFilm(rs);
        }
        return null;
    }

    /*Пробег по всем строкам таблицы и вывод в список всех названий фильмов в список*/
    private List<String> displayNameOfFilm(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList();
        while (rs.next()) {
            list.add(rs.getString("name"));
        }
        return list;
    }

    /*Запись фильма в бд*/
    private void setFilmDb(PreparedStatement pstmt, Film film) throws SQLException {
        pstmt.setString(1, film.getName());
        pstmt.setString(2, film.getLink());
        pstmt.setString(3, film.getYearAndGenre());
    }

    @Override
    public boolean insertFilm(Film film) {
        String SQL = "INSERT INTO film(name, link, yearandgenre) VALUES(?, ?, ?)";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            setFilmDb(pstmt,film);
            return assertAffectedRows(pstmt);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
            return false;
        }
    }

    @Override
    public boolean insertManyFilm(List<Film> list) {
        String SQL = "INSERT INTO film(name, link, yearandgenre) VALUES(?, ?, ?)";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            for (Film film : list) {
                setFilmDb(pstmt,film);
                pstmt.addBatch();

                count++;
                // execute every 100 rows or less
                if (count % 100 == 0 || count == list.size()-1) {
                    pstmt.executeBatch();
                }
            }
            return assertAffectedRows(pstmt);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
            return false;
        }

    }

    @Override
    public int getFilmCount() {
        String SQL = "SELECT count(*) FROM film";

        try (
                Connection con = jdbcConnection.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {

            rs.next();
            count = rs.getInt(1);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
        }
        System.out.println(count);
        return count;
    }

    @Override
    public Film getFilm() {
        String SQL = "SELECT name, link, yearandgenre FROM film";

        try (
                Connection con = jdbcConnection.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {

            return displayFilm(rs);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
        }
        return null;
    }

    @Override
    public List<String> getNameOfFilm() {
        String SQL = "SELECT name FROM film";

        try (
                Connection con = jdbcConnection.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {

            return displayNameOfFilm(rs);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
        }
        return null;
    }

    @Override
    public Film findFilmByName(String name) {
        String SQL = "SELECT name,link,yearandgenre FROM film WHERE name = ?";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            return displayFilm(rs);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
        }
        return null;
    }

    @Override
    public boolean updateFilm(String name, String link) {
        String SQL = "UPDATE film SET link = ? WHERE name = ?";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, link);
            pstmt.setString(2, name);
            return assertAffectedRows(pstmt);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
        }
        return false;
    }

    @Override
    public boolean deleteFilmByName(String name) {
        String SQL = "DELETE FROM film WHERE name = ?";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            return assertAffectedRows(pstmt);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
        }
        return false;
    }

    public static final String SqlDb = "INSERT INTO dbname(name) VALUES(?)";
    public static final String SqlSite = "INSERT INTO sitename(name) VALUES(?)";
    public static final String SqlCommon = "INSERT INTO commonname(name) VALUES(?)";

    @Override
    public boolean insertManyNameOfFilm(List<String> list, String SQL) {

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {
            int counts = 0;

            for (String name : list) {
                pstmt.setString(1, name);
                pstmt.addBatch();

                counts++;
                // execute every 100 rows or less
                if (counts % 100 == 0 || counts == list.size()-1) {
                    pstmt.executeBatch();
                }
            }
            return assertAffectedRows(pstmt);

        } catch (SQLException ex) {
            getSqlExceptionMessage(ex);
            return false;
        }

    }

/**
// Отладка методов взаимодействия с бд
    public static void main(String[] args) {
        FilmDao postgreSqlDao = new FilmDao();
        ArrayList<Film> filmList = new ArrayList();
        filmList.add(new Film("ftvvvvvgfd", "korfd", "jifc"));
        filmList.add(new Film("ftvgeeefd", "korfd", "jifc"));
        filmList.add(new Film("ftvgffrddd", "korfd", "jifc"));
        postgreSqlDao.insertManyFilm(filmList);
    }
*/

}
