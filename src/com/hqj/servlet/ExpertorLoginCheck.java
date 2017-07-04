package com.hqj.servlet;

import com.hqj.serviceimpl.ExpertServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11157 on 2017/7/4.
 */
public class ExpertorLoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name != null && password != null) {
            if (new ExpertServiceImpl().getInstance().search(name, password)) {
                request.getSession().setAttribute("expertor", "expertor");
                request.getSession().setAttribute("name", name);
                response.sendRedirect("ExpertorHome.jsp");
            } else
                response.sendRedirect("/errorpage/ExpertorLoginErr.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
