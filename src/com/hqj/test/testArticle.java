/**
 * 
 */
package com.hqj.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.serviceimpl.ArticleServiceImpl;

/**
 * @author HuangQinJian 下午4:17:25 2017年7月3日
 */
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
}
