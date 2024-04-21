package com.example.sqlapp.models;

import lombok.Data;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@ToString
public class FirmWithCount {
    Firm firm;
    int count;

    public FirmWithCount(ResultSet res) {
        this.firm = new Firm(res);
        try {
            this.count = res.getInt("count");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
