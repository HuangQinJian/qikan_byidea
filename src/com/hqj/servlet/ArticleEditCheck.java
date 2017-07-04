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
        // String title = request.getParameter("title");
        //String author = request.getParameter("author");
        //String publishdate = request.getParameter("publishdate");
        int articleid = Integer.parseInt(request.getParameter("articleid"));
        String content = request.getParameter("content");
        String editor = request.getParameter("editor");
        String edittime = request.getParameter("editor_time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(edittime);
            if (new EditorServiceImpl().updatearticle(articleid, editor, content, date)) {
                // System.out.println("yes");
                ArticleServiceImpl articleService = new ArticleServiceImpl();
                articleService.updatearticle(articleid, content);
                response.sendRedirect("/qikan/editorjsp/EditorHome.jsp");
            } else
                // System.out.println("no");
                response.sendRedirect("/qikan/errorpage/ArticleEditError.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(title);
//        System.out.println(author);
//        System.out.println(publishdate);
//        System.out.println(content);
//        System.out.println(editor);
//        System.out.println(edittime);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
