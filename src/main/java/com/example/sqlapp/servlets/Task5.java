package com.example.sqlapp.servlets;

import com.example.sqlapp.models.Country;
import com.example.sqlapp.models.Firm;
import com.example.sqlapp.models.Notepad;
import com.example.sqlapp.sevices.DB_Service_Task2;
import com.example.sqlapp.sevices.DB_Service_Task5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "task5", value = "/task5")
public class Task5 extends HttpServlet {
    DB_Service_Task2 db_2;
    DB_Service_Task5 db_5;

    public void init() {
        this.db_2 = new DB_Service_Task2();
        this.db_5 = new DB_Service_Task5();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("Notepad", db_5.getNotepad(id));
        }

        List<Notepad> allNotepads = db_2.allNotepads();
        request.setAttribute("allNotepads", allNotepads);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/sources/task5.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("method") != null){
            String method = req.getParameter("method");
            if(method.equalsIgnoreCase("delete")){
                doDelete(req, resp);
            } else if (method.equalsIgnoreCase("edit")) {
                doPut(req, resp);
            }
        }
        else{
            db_5.addRow(createNotepad(req));
        }

        List<Notepad> allNotepads = db_2.allNotepads();
        req.setAttribute("allNotepads", allNotepads);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/sources/task5.jsp");
        dispatcher.forward(req, resp);
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        Notepad notepad = createNotepad(req);
        notepad.setId(Integer.parseInt(req.getParameter("id")));
        db_5.editRow(notepad);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        db_5.removeRow(Integer.parseInt(id));

        List<Notepad> allNotepads = db_2.allNotepads();
        req.setAttribute("allNotepads", allNotepads);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/sources/task5.jsp");
        dispatcher.forward(req, resp);
    }

    Notepad createNotepad(HttpServletRequest req){
        Firm firm = new Firm(req.getParameter("firm"));
        String name = req.getParameter("name");
        int pages = Integer.parseInt(req.getParameter("pages"));
        String skinType = req.getParameter("skinType");
        Country country = new Country(req.getParameter("country"));
        String pageView = req.getParameter("pageView");
        return new Notepad(0, firm, name, pages, skinType, country, pageView);
    }

    public void destroy() {
    }
}
