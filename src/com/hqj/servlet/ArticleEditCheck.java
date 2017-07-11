package com.hqj.servlet;

import com.hqj.serviceimpl.ArticleServiceImpl;
import com.hqj.serviceimpl.EditorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 11157 on 2017/7/4.
 */
public class ArticleEditCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        int articleid = Integer.parseInt(request.getParameter("articleid"));
        String content = request.getParameter("content");
        String editor = request.getParameter("editor");
        String edittime = request.getParameter("editor_time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(edittime);
            if (new EditorServiceImpl().updatearticle(articleid, editor, content, date)) {
                ArticleServiceImpl articleService = new ArticleServiceImpl();
                articleService.updatearticle(articleid, content);
                response.sendRedirect("/qikan/editorjsp/EditorHome.jsp");
            } else
                response.sendRedirect("/qikan/errorpage/ArticleEditError.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
