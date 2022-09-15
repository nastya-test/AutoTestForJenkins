package db.dao;

import db.connection.JdbcConnection;
import model.Film;
import java.sql.*;

public class PostgreSqlDao {

    JdbcConnection jdbcConnection = new JdbcConnection();

    //Вставка фильма в таблицу
    public long insertFilm(Film film){

        String sql = "INSERT INTO film(name, link, yearandgenre) VALUES(?,?,?)";

        long id = 0;

        try (Connection con = jdbcConnection.connect();
             PreparedStatement pstmt = con.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, film.getName());
            pstmt.setString(2, film.getLink());
            pstmt.setString(3, film.getYearAndGenre());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Успешно добавлены");
        return id;

    }

    //Вывод количества фильмов
    public int getFilmCount() {
        String SQL = "SELECT count(*) FROM film";
        int count = 0;

        try (Connection con = jdbcConnection.connect();
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

    //Вывод всех фильмов
    public void getFilm() {

        String SQL = "SELECT name, link, yearandgenre FROM film";

        try (Connection con = jdbcConnection.connect();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
             displayFilm(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Метод для других, для вывода результата
    private void displayFilm(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("name") + "\t"
                    + rs.getString("link") + "\t"
                    + rs.getString("yearandgenre"));

        }
    }

    //Поиск по параметру
    public void findFilmByID(String name) {
        String SQL = "SELECT name,link,yearandgenre FROM film WHERE name = ?";

        try (Connection con = jdbcConnection.connect();
             PreparedStatement pstmt = con.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            displayFilm(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main (String[]args){
        PostgreSqlDao postgreSqlDao = new PostgreSqlDao();
        postgreSqlDao.getFilm();
    }

}
