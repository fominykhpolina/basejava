package com.basejava.webapp.web;

import com.basejava.webapp.Config;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeServlet extends HttpServlet {

    private final Storage storage = Config.get().getStorage();

    @Override
    public void init() throws ServletException {
        System.out.println("ResumeServlet ИНИЦИАЛИЗИРОВАН");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        response.getWriter().write(
                "<html><head><title>Resume List</title></head><body>" +
                        "<h1>Список резюме</h1>" +
                        "<table border='1'>" +
                        "<tr><th>UUID</th><th>Имя</th></tr>");

        for (Resume r : storage.getAllSorted()) {
            response.getWriter().write(
                    "<tr><td>" + r.getUuid() + "</td><td>" + r.getFullName() + "</td></tr>");
        }

        response.getWriter().write("</table></body></html>");
    }
}