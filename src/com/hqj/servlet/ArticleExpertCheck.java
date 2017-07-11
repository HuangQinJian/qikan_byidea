package com.hqj.servlet;

import com.hqj.serviceimpl.ArticleServiceImpl;
import com.hqj.serviceimpl.EditorServiceImpl;
import com.hqj.serviceimpl.ExpertServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 11157 on 2017/7/5.
 */
public class ArticleExpertCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        int articleid = Integer.parseInt(request.getParameter("articleid"));
        String expert = request.getParameter("expert");
        String experttime = request.getParameter("expert_time");
        String expertidea = request.getParameter("expertidea");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(experttime);
            if (new ExpertServiceImpl().updatearticle(articleid, expert, expertidea, date)) {
                response.sendRedirect("/qikan/expertorjsp/ExpertorHome.jsp");
            } else
                response.sendRedirect("/qikan/errorpage/ArticleExpertError.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
