package com.example.sqlapp.servlets;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.Firm;
import com.example.sqlapp.models.Notepad;
import com.example.sqlapp.sevices.DB_Service_Task5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create", value = "/create")
public class createNotepad extends HttpServlet {
    DB_Service_Task5 db_5;

    public void init() {
        this.db_5 = new DB_Service_Task5();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sources/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Firm firm = new Firm(req.getAttribute("firm").toString());
        String name = req.getAttribute("name").toString();
        int pages = Integer.parseInt(req.getAttribute("pages").toString());
        String skin = req.getAttribute("name").toString();
        Country country = new Country(req.getAttribute("country").toString());
        String pageView = req.getAttribute("pageView").toString();
        db_5.addRow(new Notepad(0, firm, name, pages, skin, country, pageView));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/task5");
        dispatcher.forward(req, resp);
    }


    public void destroy() {
    }
}
