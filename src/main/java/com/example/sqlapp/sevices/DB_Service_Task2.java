package com.example.sqlapp.sevices;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.CountryWithCount;
import com.example.sqlapp.models.FirmWithCount;
import com.example.sqlapp.models.Notepad;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Service_Task2 {
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/notepad";
    String USERNAME = "postgres";
    String PASSWORD = "postgre";
    String DB_DRIVER = "org.postgresql.Driver";

    public DB_Service_Task2() {
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


    public List<Notepad> allNotepads() {
        String query = "SELECT * FROM Notepads";
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

    public List<Country> allCountries() {
        String query = "SELECT DISTINCT country FROM Notepads";
        List<Country> all = new ArrayList<>();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Country(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CountryWithCount> allCountryWithCount() {
        String query = "SELECT country, COUNT(country) FROM Notepads GROUP BY country";
        List<CountryWithCount> all = new ArrayList<>();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new CountryWithCount(resultSet));
            }
            return all;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FirmWithCount> allFirmWithCount() {
        String query = "SELECT firm, COUNT(name) FROM Notepads GROUP BY firm;";
        List<FirmWithCount> all = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new FirmWithCount(resultSet));
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
