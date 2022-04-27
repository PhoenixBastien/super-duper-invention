package com.clinique;

import java.sql.*;

public class DbFunctions {

    public Connection connectToDb(String databaseName, String username, String password) {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connection established.");
            } else  {
                System.out.println("Connection failed.");
            }
        } catch (Exception e) {
            System.out.println("Exception caught.");
        }
        return connection;
    }

    public void createTable(Connection connection, String tableName) {
        try {
            String query = "CREATE TABLE " + tableName +
                    "(empId SERIAL, name varchar(200), address varchar(200), primary key(empId));";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created.");
        } catch (Exception e) {
            System.out.println("Exception caught.");
        }
    }
    public void getInfo(Connection db, String username, String password) {
        try {
            Statement statement = db.createStatement();
            ResultSet Users = statement.executeQuery("SELECT * FROM utilisateur WHERE ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
