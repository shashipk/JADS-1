package com.example.jadsjdbc.demojadsjdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {


    private static java.sql.Connection connection;

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "piyushagg@5807");
    }
}
