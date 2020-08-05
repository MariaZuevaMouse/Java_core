package com.company.mz.jdbcsocket.jdbc;

import java.sql.*;

public class JDBCApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement insertNewUserStatement;
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:jdbc_app.db");
            statement = connection.createStatement();
            insertNewUserStatement = connection.prepareStatement(
                    "INSERT INTO users (name, score) VALUES (?, ?);"
            );
            performDropTable();
            performTableCreate();
            long time =System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 0; i<100; i++){
                insertNewUserStatement.setString(1, "user_" +i);
                insertNewUserStatement.setDouble(2, i);
                insertNewUserStatement.addBatch();
            }
            insertNewUserStatement.executeBatch();
            connection.commit();
            populateDbWithUsers();

            System.out.println(System.currentTimeMillis()-time);
            readDataFromDb();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static void populateDbWithUsers() throws SQLException {
        connection.setAutoCommit(false);
        for(int i = 0; i<1000; i++){
            statement.executeUpdate(
                    "INSERT INTO users (name, score) VALUES" +
                            " ('user"+ i +"', " + i + ");"
            );
        }
        connection.commit();
    }

    private static void performTableCreate() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (\n" +
                "    id    INTEGER PRIMARY KEY,\n" +
                "    name  STRING  NOT NULL,\n" +
                "    score DOUBLE  NOT NULL\n" +
                ");");
    }

    private static void performDropTable() throws SQLException {
        statement.executeUpdate("DROP TABLE users");
    }

    private static void readDataFromDb() throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        while(resultSet.next()){
            System.out.println(
                    resultSet.getInt(1) + " | " +
                    resultSet.getString(2) + " | " +
                    resultSet.getDouble(3) + " | "

            );
        }
    }
}

