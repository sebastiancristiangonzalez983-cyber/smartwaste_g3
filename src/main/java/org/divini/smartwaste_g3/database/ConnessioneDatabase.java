package org.divini.smartwaste_g3.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {

    private final String url = "jdbc:mysql://10.130.0.173/a25c4g";
    private final String user = "a25c4g";
    private final String password = "Divini25*";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}