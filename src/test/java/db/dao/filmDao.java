package db.dao;

import db.connection.JdbcConnection;
import model.Film;
import java.sql.*;
import java.util.List;

public class filmDao implements Dao{

    JdbcConnection jdbcConnection = new JdbcConnection();
    int affectedRows = 0;
    int count = 0;
    boolean success = false;

    private boolean assertAffectedRows(){
        if (affectedRows>0){
            success=true;
            System.out.println("Успешно выполнено");
        }
        return success;
    }

    private Film convertFilm(ResultSet rs) throws SQLException {
        Film film = new Film();
        film.setName(rs.getString("name"));
        film.setLink(rs.getString("link"));
        film.setYearAndGenre(rs.getString("yearandgenre"));
        return film;
    }

    private Film displayFilm(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(convertFilm(rs));
            return convertFilm(rs);
//            System.out.println(rs.getString("name") + "\t"
//                    + rs.getString("link") + "\t"
//                    + rs.getString("yearandgenre"));
        }
        return null;
    }

    @Override
    public boolean insertFilm(Film film) {
        String SQL = "INSERT INTO film(name, link, yearandgenre) VALUES(?, ?, ?)";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, film.getName());
            pstmt.setString(2, film.getLink());
            pstmt.setString(3, film.getYearAndGenre());
            affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return assertAffectedRows();
    }

    @Override
    public boolean insertManyFilm(List<Film> list) {
        String SQL = "INSERT INTO film(name, link, yearandgenre) VALUES(?, ?, ?)";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            for (Film film : list) {
                pstmt.setString(1, film.getName());
                pstmt.setString(2, film.getLink());
                pstmt.setString(3, film.getYearAndGenre());
                pstmt.addBatch();
                count++;
                // execute every 100 rows or less
                if (count % 100 == 0 || count == list.size()) {
                    pstmt.executeBatch();
                }
            }
            affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return assertAffectedRows();
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
            System.out.println(ex.getMessage());
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
            System.out.println(ex.getMessage());
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
            System.out.println(ex.getMessage());
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
            affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return assertAffectedRows();
    }

    @Override
    public boolean deleteFilmByName(String name) {
        String SQL = "DELETE FROM film WHERE name = ?";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return assertAffectedRows();
    }

// Отладка методов взаимодействия с бд
    public static void main(String[] args) {
        filmDao postgreSqlDao = new filmDao();
//        ArrayList<Film> filmList = new ArrayList();
//        filmList.add(new Film("ftvvvvvgfd", "korfd", "jifc"));
//        filmList.add(new Film("ftvgeeefd", "korfd", "jifc"));
//        filmList.add(new Film("ftvgffrddd", "korfd", "jifc"));
        postgreSqlDao.getFilm();
    }

}
