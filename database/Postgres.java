package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres {
    private static final String URL = "";
    private static final String USUARIO = "";
    private static final String SENHA = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}