package com.hqj.servlet;

import com.hqj.serviceimpl.ArticleServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11157 on 2017/7/11.
 */
public class GetIdByArticleTitle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String title = request.getParameter("input_value");
        Logger logger = Logger.getLogger(this.getClass().getName());
        int articleid = new ArticleServiceImpl().getInstance().getidByArticleTitle(title);
        if (articleid == 0) {
            logger.error("没有找到文章");
            response.sendRedirect("/qikan/errorpage/ArticleNotFound.jsp");
        } else {
            logger.info("查找到该文章");
            response.sendRedirect("ShowHomeArticle.jsp?id=" + articleid);
        }
    }
}
