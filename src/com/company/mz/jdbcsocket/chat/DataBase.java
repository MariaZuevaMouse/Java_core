package com.company.mz.jdbcsocket.chat;

import java.sql.*;
import java.time.LocalDate;

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedAddRowToDb;


    public static void connectDb(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createTable(){
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ChatHistory (\n" +
                    "    id      INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    FromUser  STRING  NOT NULL,\n" +
                    "    Message STRING  NOT NULL,\n" +
                    "    DateTime    TIME    NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addRecordToDb(String message,  boolean isServer){
        try {
            preparedAddRowToDb = connection.prepareStatement("INSERT INTO ChatHistory (FromUser, Message, DateTime) VALUES (?, ?, ?);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isServer){
            try {
                preparedAddRowToDb.setString(1,"server");
                preparedAddRowToDb.setString(2, message);
                preparedAddRowToDb.setDate(3, Date.valueOf(LocalDate.now()));
                preparedAddRowToDb.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                preparedAddRowToDb.setString(1,"server");
                preparedAddRowToDb.setString(2, message);
                preparedAddRowToDb.setDate(3, Date.valueOf(LocalDate.now()));
                preparedAddRowToDb.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
