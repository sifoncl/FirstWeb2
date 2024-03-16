package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/UserHTML.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getInstance();

        int reqId = Integer.parseInt(req.getParameter("id"));
        String reqName = req.getParameter("name");
        boolean isExist = userService.getUser(reqId).isPresent();
        if (isExist){
            UserDto user = userService.getUser(reqId).get();

            boolean allowed = false;
            if (user.getId() == reqId && user.getName().equals(reqName)) {
                allowed = true;
            }
            if (allowed == true) {

                resp.sendRedirect(req.getContextPath()+"/users_info"+"?id="+reqId);

            } else {
                resp.sendRedirect(req.getContextPath() + "/WrongIdName.html");
            }
        }else resp.sendRedirect(req.getContextPath() + "/WrongIdName.html");
    }


}