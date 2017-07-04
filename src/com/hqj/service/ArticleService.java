/**
 *
 */
package com.hqj.service;

import java.util.ArrayList;

import com.hqj.model.Article;

public interface ArticleService {
    public boolean addarticle(Article article);

    public boolean updatearticle(Article article);

    public boolean delarticle(Article article);

    public ArrayList<Article> display();

    public ArrayList<Article> searchByAuthorName(String authorName);

    public Article SearchArticleById(int id);
}
