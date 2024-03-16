package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users_game")
public class UserGame extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService us = UserService.getInstance();

        int id = Integer.parseInt(req.getParameter("id"));

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<h2>Твой счет: " + us.getUser(id).get().getCount() + "</h2>");
        writer.write("<form action=" + req.getContextPath() + "/users_game?id=" + id + " method=\"post\">\n" +
                "    <input type=\"submit\" value=\"Добавить\">\n" +
                "</form>");
        writer.write("</html></body>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService us = UserService.getInstance();
        int id = Integer.parseInt(req.getParameter("id"));
        us.increseCountByOne(id);
        System.out.println("пытался");
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<h2>Твой счет: " + us.getUser(id).get().getCount() + "</h2>");
        writer.write("<form action=" + req.getContextPath() + "/users_game?id=" + id + " method=\"post\">\n" +
                "    <input type=\"submit\" value=\"Добавить\">\n" +
                "</form>");
        writer.write("</html></body>");
        DbManager.saveDb(us.getDb());
    }
}
