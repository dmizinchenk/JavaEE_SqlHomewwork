package com.example.sqlapp.servlets;

import com.example.sqlapp.models.*;
import com.example.sqlapp.sevices.DB_Service_Task2;
import com.example.sqlapp.sevices.DB_Service_Task3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "taks3", value = "/task3")
public class Task3 extends HttpServlet {
    DB_Service_Task3 db_3;

    public void init() {
        this.db_3 = new DB_Service_Task3();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        Country countryWithMaxNotepads;
        Country countryWithMinNotepads;
        Firm firmWithMaxNotepads;
        Firm firmWithMinNotepads;
        List<Notepad> hardSkin;
        List<Notepad> softSkin;

        countryWithMaxNotepads = db_3.CountryWithMaxNotepads();
        countryWithMinNotepads = db_3.CountryWithMinNotepads();
        firmWithMaxNotepads = db_3.FirmWithMaxNotepads();
        firmWithMinNotepads = db_3.FirmWithMinNotepads();
        hardSkin = db_3.allNotepadsWithSkinHard();
        softSkin = db_3.allNotepadsWithSkinSoft();

        request.setAttribute("countryWithMaxNotepads", countryWithMaxNotepads);
        request.setAttribute("countryWithMinNotepads", countryWithMinNotepads);
        request.setAttribute("firmWithMaxNotepads", firmWithMaxNotepads);
        request.setAttribute("firmWithMinNotepads", firmWithMinNotepads);
        request.setAttribute("hardSkin", hardSkin);
        request.setAttribute("softSkin", softSkin);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/sources/task3.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
