package com.example.sqlapp.models;

import lombok.Data;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@ToString
@Data
public class CountryWithCount {
    Country country;
    int count;

    public CountryWithCount(ResultSet res) {
        this.country = new Country(res);
        try {
            this.count = res.getInt("count");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
