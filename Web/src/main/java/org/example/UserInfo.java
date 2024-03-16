package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/users_info")
public class UserInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService us = UserService.getInstance();

        int id = Integer.parseInt(req.getParameter("id"));

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<h2>Id пользователя: " + us.getUser(id).get().getId() + "</h2>");
        writer.write("<h2>Имя пользователя: " + us.getUser(id).get().getName() + "</h2>");
        writer.write("<h2>Счет пользователя: " + us.getUser(id).get().getCount() + "</h2>");
        writer.write("<a href=\"" + req.getContextPath() + "/change_name?id=" + id + "\">Сменить имя+ </a>");
        writer.write("<br>");
        writer.write("<a href=\"" + req.getContextPath() + "/users_game?id=" + id + "\">Поиграем?</a>");

        writer.write("</html></body>");


    }
}
