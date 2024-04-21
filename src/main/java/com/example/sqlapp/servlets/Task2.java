package com.example.sqlapp.servlets;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.CountryWithCount;
import com.example.sqlapp.models.FirmWithCount;
import com.example.sqlapp.models.Notepad;
import com.example.sqlapp.sevices.DB_Service_Task2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "taks2", value = "/task2")
public class Task2 extends HttpServlet {
    DB_Service_Task2 db_2;

    public void init() {
        this.db_2 = new DB_Service_Task2();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        List<Notepad> notepads;
        List<Country> countries;
        List<CountryWithCount> countriesWithCount;
        List<FirmWithCount> firmWithCount;

        notepads = db_2.allNotepads();
        countries = db_2.allCountries();
        countriesWithCount = db_2.allCountryWithCount();
        firmWithCount = db_2.allFirmWithCount();

        request.setAttribute("allNotepads", notepads);
        request.setAttribute("allCountries", countries);
        request.setAttribute("allCountryWithCount", countriesWithCount);
        request.setAttribute("allFirmWithCount", firmWithCount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/sources/task2.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
