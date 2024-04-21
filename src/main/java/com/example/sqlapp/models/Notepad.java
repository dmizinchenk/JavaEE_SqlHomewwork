package com.example.sqlapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
public class Notepad {
    int id;
    Firm firm;
    String name;
    int pages;
    String skin;
    Country country;
    String pageView;

    public Notepad(ResultSet res) {
        try {
            this.id = res.getInt("id");
            this.firm = new Firm(res);
            this.name = res.getString("name");
            this.pages = res.getInt("pages");
            this.skin = res.getString("skinType");
            this.country = new Country(res);
            this.pageView = res.getString("pageView");
        } catch (SQLException e) {
            System.out.println("Notepad not created");
            throw new RuntimeException(e);
        }
    }
}
