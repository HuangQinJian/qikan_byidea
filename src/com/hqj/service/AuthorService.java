/**
 *
 */
package com.hqj.service;

import com.hqj.model.Article;
import com.hqj.model.Author;

public interface AuthorService {
    public boolean add(Author author);

    public boolean delete(Author author);

    public boolean update(Author author);

    public boolean search(String name, String password);

    public boolean addArticle(Article article);
}
