package com.example.authorization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String Name, String Login, String Password) {
        String insert = "INSERT INTO " + Const.USER_TABLE + " (" +
                Const.USER_NAME + ", " + Const.USER_LOGIN + ", " +
                Const.USER_PASSWORD + ") VALUES (?, ?, ?)";
        try {
            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
                prSt.setString(1, Name);
                prSt.setString(2, Login);
                prSt.setString(3, Password);

                prSt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Обработка и вывод информации об ошибке
        }
    }
}