package com.example.sqlapp.sevices;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.Firm;
import com.example.sqlapp.models.Notepad;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Service_Task3 {
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/notepad";
    String USERNAME = "postgres";
    String PASSWORD = "postgre";
    String DB_DRIVER = "org.postgresql.Driver";

    public DB_Service_Task3() {
        try {
            initConnection();
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("драйвер не подключен");
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            System.out.println("конфиг не найден");
            throw new RuntimeException(e);
        }
    }

    private void initConnection() throws FileNotFoundException, ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }


    public Country CountryWithMaxNotepads() {
        String query = "SELECT country " +
                "FROM (SELECT country, COUNT(id) as noteCount " +
                "      FROM Notepads " +
                "      GROUP BY country) " +
                "WHERE noteCount =  (SELECT MAX(counts) " +
                "                    FROM (SELECT COUNT(country) as counts " +
                "                          FROM Notepads " +
                "                          GROUP BY country));";
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Country(resultSet);
    }

    public Country CountryWithMinNotepads() {
        String query = "SELECT country " +
                "FROM (SELECT country, COUNT(id) as noteCount " +
                "      FROM Notepads\n" +
                "      GROUP BY country) " +
                "WHERE noteCount =  (SELECT MIN(counts) " +
                "                    FROM (SELECT COUNT(country) as counts " +
                "                          FROM Notepads " +
                "                          GROUP BY country));";
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Country(resultSet);
    }

    public Firm FirmWithMaxNotepads() {
        String query = "SELECT firm " +
                "FROM (SELECT firm, COUNT(id) as noteCount " +
                "      FROM Notepads " +
                "      GROUP BY firm) " +
                "WHERE noteCount =  (SELECT MAX(counts) " +
                "                    FROM (SELECT COUNT(firm) as counts " +
                "                          FROM Notepads " +
                "                          GROUP BY firm));";
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Firm(resultSet);
    }

    public Firm FirmWithMinNotepads() {
        String query = "SELECT firm " +
                "FROM (SELECT firm, COUNT(id) as noteCount " +
                "      FROM Notepads " +
                "      GROUP BY firm) " +
                "WHERE noteCount =  (SELECT MIN(counts) " +
                "                    FROM (SELECT COUNT(firm) as counts " +
                "                          FROM Notepads " +
                "                          GROUP BY firm));";
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Firm(resultSet);
    }

    public List<Notepad> allNotepadsWithSkinHard() {
        String query = "SELECT * " +
                        "FROM Notepads " +
                        "WHERE skinType = 'hard'";
        List<Notepad> all = new ArrayList<>();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Notepad(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Notepad> allNotepadsWithSkinSoft() {
        String query = "SELECT * " +
                        "FROM Notepads " +
                        "WHERE skinType = 'soft'";
        List<Notepad> all = new ArrayList<>();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Notepad(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws SQLException {
        this.connection.close();
    }
}
