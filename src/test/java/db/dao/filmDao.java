package db.dao;

import db.connection.JdbcConnection;
import model.Film;
import java.sql.*;

public class filmDao {

    JdbcConnection jdbcConnection = new JdbcConnection();
    int affectedRows = 0;
    int count = 0;

    private void displayFilm(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("name") + "\t"
                    + rs.getString("link") + "\t"
                    + rs.getString("yearandgenre"));
        }
    }

    public void insertFilm(Film film) {
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
        System.out.println(affectedRows);
        System.out.println("Фильм добавлен в бд");
    }

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

    public void getFilm() {
        String SQL = "SELECT name, link, yearandgenre FROM film";

        try (
                Connection con = jdbcConnection.connect();
                Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(SQL)) {
            displayFilm(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findFilmByName(String name) {
        String SQL = "SELECT name,link,yearandgenre FROM film WHERE name = ?";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            displayFilm(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateFilm(String name, String link) {
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
        System.out.println(affectedRows);
    }

    public void deleteFilmByName(String name) {
        String SQL = "DELETE FROM film WHERE name = ?";

        try (
                Connection con = jdbcConnection.connect();
                PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            affectedRows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(affectedRows);
    }

// Отладка методов взаимодействия с бд
//    public static void main(String[] args) {
//        filmDao postgreSqlDao = new filmDao();
//        postgreSqlDao.deleteFilmByName("имя1");
//    }

}
