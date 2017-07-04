/**
 * 
 */
package com.hqj.serviceimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.model.DB;
import com.hqj.service.ArticleService;
import com.mysql.jdbc.Connection;

public class ArticleServiceImpl implements ArticleService {
	private ArticleServiceImpl aImpl = null;

	public ArticleServiceImpl getInstance() {
		if (aImpl == null) {
			System.out.println("第一次初始化ArticleServiceImpl");
			aImpl = new ArticleServiceImpl();
		}
		return aImpl;
	}

	Connection conn = DB.getConn();
	Statement st = DB.getStatement(conn);
	private PreparedStatement pstmt = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hqj.service.ArticleService#addarticle(com.hqj.model.Article)
	 */
	@Override
	public boolean addarticle(Article article) {
		// TODO Auto-generated method stub
		String sql = "insert into article(author,title,time,content) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getAutor().getAutoname());
			pstmt.setString(2, article.getTitle());
			pstmt.setDate(3, new java.sql.Date(article.getPublishdate()
					.getTime()));
			pstmt.setString(4, article.getContent());
			if (pstmt.executeUpdate() == 1) {
				System.out.println("查询时的sql语句是" + sql);
				System.out.println("yes");
				return true;
			} else {
				System.out.println("no");
				// return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hqj.service.ArticleService#updatearticle(com.hqj.model.Article)
	 */
	@Override
	public boolean updatearticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hqj.service.ArticleService#delarticle(com.hqj.model.Article)
	 */
	@Override
	public boolean delarticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hqj.service.ArticleService#display()
	 */
	@Override
	public ArrayList<Article> display() {
		// TODO Auto-generated method stub
		String sql = "select * from article";
		ResultSet rSet = DB.getResultSet(st, sql);
		ArrayList<Article> arrayList = new ArrayList<Article>();
		try {
			while (rSet.next()) {
				Article article = new Article();
				article.setId(rSet.getInt(1));
				Author autor = new Author();
				autor.setAutoname(rSet.getString(2));
				article.setAutor(autor);
				article.setTitle(rSet.getString(3));
				article.setPublishdate(rSet.getDate(4));
				article.setContent(rSet.getString(5));
				arrayList.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hqj.service.ArticleService#searchByAuthorId(int)
	 */
	@Override
	public ArrayList<Article> searchByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		String sql = "select * from article where author=" + "'" + authorName
				+ "'";
		ResultSet rSet = DB.getResultSet(st, sql);
		ArrayList<Article> arrayList = new ArrayList<Article>();
		try {
			while (rSet.next()) {
				Article article = new Article();
				Author autor = new Author();
				autor.setAutoname(rSet.getString(2));
				article.setAutor(autor);
				article.setTitle(rSet.getString(3));
				article.setPublishdate(rSet.getDate(4));
				article.setContent(rSet.getString(5));
				arrayList.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hqj.service.ArticleService#SearchArticleById(int)
	 */
	@Override
	public Article SearchArticleById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from article where id=" + id;
		ResultSet rSet = DB.getResultSet(st, sql);
		Article article = new Article();
		try {
			while (rSet.next()) {
				article.setId(rSet.getInt(1));
				Author autor = new Author();
				autor.setAutoname(rSet.getString(2));
				article.setAutor(autor);
				article.setTitle(rSet.getString(3));
				article.setPublishdate(rSet.getDate(4));
				article.setContent(rSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}

}
