package com.example.sqlapp.sevices;

import com.example.sqlapp.models.Notepad;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Service_Task5 {
    private Connection connection;

    String DB_URL = "jdbc:postgresql://localhost:5432/notepad";
    String USERNAME = "postgres";
    String PASSWORD = "postgre";
    String DB_DRIVER = "org.postgresql.Driver";

    public DB_Service_Task5() {
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

    public void addRow(Notepad notepad) {
        String query = "INSERT INTO Notepads (firm, name, pages, skinType, country, pageView) VALUES (" +
                "'" + notepad.getFirm().getName() + "', " +
                "'" + notepad.getName() + "', " +
                notepad.getPages() + ", " +
                "'" + notepad.getSkin() + "', " +
                "'" + notepad.getCountry().getName() + "', " +
                "'" + notepad.getPageView() + "');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editRow(Notepad notepad) {
        String query = "UPDATE Notepads SET " +
                "firm = '" + notepad.getFirm().getName() + "', " +
                "name = '" + notepad.getName() + "', " +
                "pages = " + notepad.getPages() + ", " +
                "skinType = '" + notepad.getSkin() + "', " +
                "country = '" + notepad.getCountry().getName() + "', " +
                "pageView = '" + notepad.getPageView() + "' " +
                "WHERE id = " + notepad.getId() + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeRow(int id) {
        String query = "DELETE FROM Notepads WHERE id = " + id + ";";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Notepad getNotepad(int id) {
        String query = "SELECT * FROM Notepads WHERE id = " + id;
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            return new Notepad(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws SQLException {
        this.connection.close();
    }
}
