package com.example.sqlapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@ToString
@AllArgsConstructor
public class Firm {
    String name;

    public Firm(ResultSet result) {
        try {
            this.name = result.getString("firm");
        } catch (SQLException e) {
            System.out.println("Firm not created");
            throw new RuntimeException(e);
        }
    }
}
