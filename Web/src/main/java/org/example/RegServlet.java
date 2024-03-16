package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserService.getInstance();

        int reqId = Integer.parseInt( req.getParameter("id"));
        String reqName = req.getParameter("name");
        userService.addUser(reqName,reqId);
        resp.sendRedirect(req.getContextPath() + "/UserHTML.html");

        DbManager.saveDb(userService.getDb());
    }
}
