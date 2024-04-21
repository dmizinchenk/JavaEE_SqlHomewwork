package com.example.sqlapp.sevices;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.Firm;
import com.example.sqlapp.models.Notepad;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Service_Task4 {
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/notepad";
    String USERNAME = "postgres";
    String PASSWORD = "postgre";
    String DB_DRIVER = "org.postgresql.Driver";

    public DB_Service_Task4() {
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

    public List<Notepad> allNotepadsByCountry(Country country) {
        String query = "SELECT * FROM Notepads WHERE country = '" + country.getName() + "'";
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
    public List<Notepad> allNotepadsByPageView(String pageView) {
        String query = "SELECT * FROM Notepads WHERE pageView = '" + pageView + "'";
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

    public List<Notepad> allNotepadsByPagesCount(int pages) {
        String query = "SELECT * FROM Notepads WHERE pages = " + pages;
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

    public List<String> noteSkin() {
        String query = "SELECT DISTINCT pageView FROM Notepads";
        ResultSet resultSet;
        List<String> pageView = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                pageView.add(resultSet.getString("pageView"));
            }
            return pageView;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> pagesCount() {
        String query = "SELECT DISTINCT pages FROM Notepads";
        ResultSet resultSet;
        List<Integer> pages = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                pages.add(resultSet.getInt("pages"));
            }
            return pages;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws SQLException {
        this.connection.close();
    }
}
