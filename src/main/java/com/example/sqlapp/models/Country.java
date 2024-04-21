package com.example.sqlapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@ToString
@AllArgsConstructor
public class Country {
    String name;

    public Country(ResultSet result) {
        try {
            this.name = result.getString("country");
        } catch (SQLException e) {
            System.out.println("Country not created");
            throw new RuntimeException(e);
        }
    }
}
