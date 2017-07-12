package com.hqj.service;

import com.hqj.model.Article;

import java.util.ArrayList;
import java.util.Date;

public interface ArticleService {
    public boolean addarticle(Article article);

    public boolean updatearticle(int id, String editordetail);

    public boolean editorarticle(int id, String editorname, String editordetail, Date editortime);

    public boolean expertarticle(int id, String expertname, String expertidea, Date experttime);

    public boolean delarticle(Article article);

    public ArrayList<Article> display();

    public ArrayList<Article> displaydetail();

    public ArrayList<Article> searchByAuthorName(String authorName);

    public Article SearchArticleById(int id);

    public int getidByArticleTitle(String title);

    public ArrayList<Article> NotEditor();

    public ArrayList<Article> NotExpert();
}
