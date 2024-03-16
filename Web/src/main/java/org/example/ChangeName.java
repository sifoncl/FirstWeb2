package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/change_name")
public class ChangeName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService us = UserService.getInstance();
        int id = Integer.parseInt(req.getParameter("id"));
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<h2>Текущее имя: " + us.getUser(id).get().getName() + "</h2>");
        writer.write("<form action=" + req.getContextPath() + "/change_name method=\"post\">\n" +
                "    Name<input type=\"text\" name=\"name\">" +
                "    Id <input type=\"text\" name=\"id\">" +
                "    <input type=\"submit\" value=\"Обновить\">" +
                "</form>");
        writer.write("</html></body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService us = UserService.getInstance();
        int id = Integer.parseInt(req.getParameter("id"));
        us.updateName(id, req.getParameter("name"));

        DbManager.saveDb(us.getDb());
        resp.sendRedirect(req.getContextPath() + "/users_info" + "?id=" + id);
    }
}
