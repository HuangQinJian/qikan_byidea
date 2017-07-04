package com.hqj.servlet;

import com.hqj.model.Expert;
import com.hqj.serviceimpl.ExpertServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11157 on 2017/7/4.
 */
public class ExpertorRegiest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        Expert expert = new Expert();
        expert.setExpename(name);
        expert.setExpepass(password);
        if (name != null && password != null) {
            if (new ExpertServiceImpl().getInstance().add(expert)) {
                response.sendRedirect("ExpertorLogin.jsp");
            } else
               response.sendRedirect("/errorpage/ExpertorRegiestErr.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
