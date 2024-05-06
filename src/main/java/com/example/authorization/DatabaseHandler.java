package com.example.authorization;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
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

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {
                prSt.setString(1, user.getLogin());
                prSt.setString(2, user.getPassword());

                resSet = prSt.executeQuery(); // Присвоение результата запроса к переменной resSet
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Обработка и вывод информации об ошибке
        }

        return resSet; // Возвращение результата запроса
    }
}