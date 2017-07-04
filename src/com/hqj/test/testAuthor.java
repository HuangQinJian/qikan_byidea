/**
 * 
 */
package com.hqj.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.serviceimpl.ArticleServiceImpl;
import com.hqj.serviceimpl.AuthorServiceImpl;

/**
 * @author HuangQinJian
 * 上午10:37:51
 * 2017年6月29日
 */
public class testAuthor {
	AuthorServiceImpl authorimpl=new AuthorServiceImpl().getInstance();
    @Test
    public void addAuthor() {
	  Author author=new Author();
	  author.setAutoname("123");
	  author.setAutopass("123");
	  if(authorimpl.add(author))
		  System.out.println("yes");
	  else 
		  System.out.println("no");
    }
    
    @Test
    public void deleteAuthor() {
	  Author author=new Author();
	  author.setAutoname("123");
	  author.setAutopass("123");
	  if(authorimpl.delete(author))
		  System.out.println("yes");
	  else 
		  System.out.println("no");
    }
    
    @Test
    public void searchAuthor() {
    	if(authorimpl.search("qin", "123")){
    		System.out.println("yes");
    	}
    	else
    		System.out.println("no");
    }
    
    @Test
	public void addArticle() throws ParseException {
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
}
