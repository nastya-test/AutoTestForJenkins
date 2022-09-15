package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public Connection connect() {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("File -> ProjectStructure -> Libraries -> add org.postgresql.Driver");
            e.printStackTrace();
        }
        return conn;
    }

//    Проверка соединения с базой
//    public static void main (String[]args){
//        JdbcConnection app = new JdbcConnection();
//        app.connect();
//    }

}
