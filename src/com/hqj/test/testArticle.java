/**
 *
 */
package com.hqj.test;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.serviceimpl.ArticleServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testArticle {
    @Test
    public void addarticle() throws ParseException {
        String title = "wo";
        Author author = new Author();
        author.setAutoname("huang");
        Article article = new Article();
        String content = "aini";
        article.setTitle(title);
        article.setAutor(author);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        article.setPublishdate(sdf.parse(("2015-10-06")));
        article.setContent(content);
        if (new ArticleServiceImpl().addarticle(article)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    @Test
    public void display() {
        System.out.println(new ArticleServiceImpl().display());
    }

    @Test
    public void searchByAuthorName() {
        System.out.println(new ArticleServiceImpl().searchByAuthorName("liu")
                .size());
    }

    @Test
    public void SearchArticleById() {
        System.out.println(new ArticleServiceImpl().SearchArticleById(3));
    }

    @Test
    public void editorarticle() {
        Date d = new Date();
        if (new ArticleServiceImpl().editorarticle(4, "sasww", "sasasasw", d))
            System.out.println("yes");
        else
            System.out.println("no");
    }

    @Test
    public void expertarticle() {
        Date d = new Date();
        if (new ArticleServiceImpl().expertarticle(212, "wqw", "wqw", d))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
