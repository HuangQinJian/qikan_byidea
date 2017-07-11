package com.hqj.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.serviceimpl.AuthorServiceImpl;

/**
 * Servlet implementation class ArticleAddCheck
 */
public class ArticleAddCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleAddCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String publish_time = request.getParameter("publish_time");
        String author = request.getParameter("author");
        String content = request.getParameter("article_content").trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Article article = new Article();
        Author authors = new Author();
        authors.setAutoname(author);
        article.setTitle(title);
        try {
            article.setPublishdate(sdf.parse(publish_time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        article.setAutor(authors);
        article.setContent(content);
        if (new AuthorServiceImpl().getInstance().addArticle(article)) {
            response.sendRedirect("/qikan/ueditor/authorjsp/AuthorHome.jsp");
        } else {
            response.sendRedirect("/qikan/errorpage/ArticleAddError.jsp");
        }
    }

}
