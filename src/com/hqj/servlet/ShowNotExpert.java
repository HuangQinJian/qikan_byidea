package com.hqj.servlet;

import com.alibaba.fastjson.JSON;
import com.hqj.model.Article;
import com.hqj.serviceimpl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 11157 on 2017/7/12.
 */
public class ShowNotExpert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        ArticleServiceImpl aImpl = new ArticleServiceImpl();
        List<Article> list = aImpl.NotExpert();
        String json = JSON.toJSONString(list);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
