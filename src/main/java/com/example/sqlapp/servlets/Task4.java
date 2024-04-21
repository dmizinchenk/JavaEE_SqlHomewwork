package com.example.sqlapp.servlets;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.Notepad;
import com.example.sqlapp.sevices.DB_Service_Task2;
import com.example.sqlapp.sevices.DB_Service_Task4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "task4", value = "/task4")
public class Task4 extends HttpServlet {
    DB_Service_Task4 db_4;
    DB_Service_Task2 db_2;

    public void init() {
        this.db_2 = new DB_Service_Task2();
        this.db_4 = new DB_Service_Task4();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        List<Country> countries = db_2.allCountries();
        request.setAttribute("allCountries", countries);
        List<String> skins = db_4.noteSkin();
        request.setAttribute("allSkins", skins);
        List<Integer> pages = db_4.pagesCount();
        request.setAttribute("pages", pages);

        List<Notepad> allNotepadsByCountry;
        List<Notepad> allNotepadsByPageView;
        List<Notepad> allNotepadsByPagesCount;

        String country = request.getParameter("chosenCountry");
        if(country == null || country.isEmpty()){
            allNotepadsByCountry = db_2.allNotepads();
        }
        else {
            allNotepadsByCountry = db_4.allNotepadsByCountry(new Country(country));
        }

        String skin = request.getParameter("pageView");
        if(skin == null || skin.isEmpty()){
            allNotepadsByPageView = db_2.allNotepads();
        }
        else {
            allNotepadsByPageView = db_4.allNotepadsByPageView(skin);
        }

        String page = request.getParameter("chosenPage");
        if(page == null || page.isEmpty()){
            allNotepadsByPagesCount = db_2.allNotepads();
        }
        else {
            allNotepadsByPagesCount = db_4.allNotepadsByPagesCount(Integer.parseInt(page));
        }

        request.setAttribute("allNotepadsByCountry", allNotepadsByCountry);
        request.setAttribute("allNotepadsByPageView", allNotepadsByPageView);
        request.setAttribute("allNotepadsByPagesCount", allNotepadsByPagesCount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/sources/task4.jsp");
        dispatcher.forward(request, response);

    }

    public void destroy() {
    }
}
