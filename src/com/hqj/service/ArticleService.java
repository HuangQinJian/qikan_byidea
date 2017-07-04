/**
 *
 */
package com.hqj.service;

import java.util.ArrayList;
import java.util.Date;

import com.hqj.model.Article;

public interface ArticleService {
    public boolean addarticle(Article article);

    public boolean updatearticle(int id, String editordetail);

    public boolean editorarticle(int id, String editorname, String editordetail, Date editortime);

    public boolean delarticle(Article article);

    public ArrayList<Article> display();

    public ArrayList<Article> searchByAuthorName(String authorName);

    public Article SearchArticleById(int id);
}
