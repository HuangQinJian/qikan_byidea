package com.hqj.serviceimpl;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.model.DB;
import com.hqj.service.ArticleService;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleServiceImpl implements ArticleService {
    private static ArticleServiceImpl aImpl = null;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    DB db = new DB();

    public static ArticleServiceImpl getInstance() {
        if (aImpl == null) {
            //logger.info("第一次初始化ArticleServiceImpl");
            //System.out.println("第一次初始化ArticleServiceImpl");
            aImpl = new ArticleServiceImpl();
        }
        return aImpl;
    }

    Connection conn = db.getConn();
    Statement st = db.getStatement(conn);
    private PreparedStatement pstmt = null;

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.ArticleService#addarticle(com.hqj.model.Article)
     * 实现添加作者新增文章功能
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
                logger.info("添加时的sql语句是" + sql);
                //System.out.println("查询时的sql语句是" + sql);
                // System.out.println("yes");
                return true;
            } else {
                logger.info("添加文章失败！");
                //System.out.println("no");
                // return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /*
    实现文章内容更新的功能
     */
    @Override
    public boolean updatearticle(int id, String editordetail) {
        String sql = "update article set content=?  where id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, editordetail);
            pstmt.setInt(2, id);
            if (pstmt.executeUpdate() == 1) {
                logger.info("更新时的sql语句是" + sql);
                // System.out.println("更新时的sql语句是" + sql);
                //  System.out.println("yes");
                return true;
            } else {
                logger.info("更新文章失败！");
                // System.out.println("no");
                // return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 编辑者对于文章修改
     * @see com.hqj.service.ArticleService#updatearticle(com.hqj.model.Article)
     */
    @Override
    public boolean editorarticle(int id, String editorname, String editordetail, java.util.Date editortime) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO article_detail(articleid,editorname,editordetail,editortime) VALUES (?,?,?,?) ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, editorname);
            pstmt.setString(3, editordetail);
            pstmt.setDate(4, new java.sql.Date(editortime.getTime()));
            if (pstmt.executeUpdate() == 1) {
                logger.info("编辑者更新时的sql语句是" + sql);
                // System.out.println("更新时的sql语句是" + sql);
                //System.out.println("yes");
                return true;
            } else {
                logger.info("编辑者更新文章失败！");
                //System.out.println("no");
                // return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    专家对于文章的修改意见
     */
    @Override
    public boolean expertarticle(int id, String expertname, String expertidea, java.util.Date experttime) {
        String sql = "INSERT INTO article_idea (articleid,expertname,expertidea,experttime) VALUES (?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, expertname);
            pstmt.setString(3, expertidea);
            pstmt.setDate(4, new java.sql.Date(experttime.getTime()));
            if (pstmt.executeUpdate() == 1) {
                logger.info("专家更新时的sql语句是" + sql);
                // System.out.println("更新时的sql语句是" + sql);
                // System.out.println("yes");
                return true;
            } else {
                logger.info("专家更新文章失败！");
                // System.out.println("no");
                // return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * (non-Javadoc)
     *  删除文章
     * @see com.hqj.service.ArticleService#delarticle(com.hqj.model.Article)
     */
    @Override
    public boolean delarticle(Article article) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *  显示所有文章
     * @see com.hqj.service.ArticleService#display()
     */
    @Override
    public ArrayList<Article> display() {
        // TODO Auto-generated method stub
        String sql = "select * from article";
        ResultSet rSet = db.getResultSet(st, sql);
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

    @Override
    public ArrayList<Article> displaydetail() {
        return null;
    }

    /*
     * (non-Javadoc)
     *  通过作者名字对文章进行搜索
     * @see com.hqj.service.ArticleService#searchByAuthorId(int)
     */
    @Override
    public ArrayList<Article> searchByAuthorName(String authorName) {
        // TODO Auto-generated method stub
        String sql = "select * from article where author=" + "'" + authorName
                + "'";
        ResultSet rSet = db.getResultSet(st, sql);
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
     * 通过文章ID对文章进行搜索
     * @see com.hqj.service.ArticleService#SearchArticleById(int)
     */
    @Override
    public Article SearchArticleById(int id) {
        // TODO Auto-generated method stub
        String sql = "select * from article where id=" + id;
        ResultSet rSet = db.getResultSet(st, sql);
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

    /*
    根据文章标题得到文章ID
     */

    @Override
    public int getidByArticleTitle(String title) {
        String sql = "select * from article where title=" + "'" + title
                + "'";
        ResultSet rSet = db.getResultSet(st, sql);
        try {
            while (rSet.next()) {
                return rSet.getInt("id");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /*
    展示所有未被编辑过的页面
     */
    @Override
    public ArrayList<Article> NotEditor() {
        String sql = "select * from article where id not in (select articleid from article_detail) ";
        ResultSet rSet = db.getResultSet(st, sql);
        ArrayList<Article> arrayList = new ArrayList<Article>();
        try {
            while (rSet.next()) {
                Article article = new Article();
                Author autor = new Author();
                autor.setAutoname(rSet.getString(2));
                article.setId(rSet.getInt(1));
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
    展示所有专家未评审过的页面
     */
    @Override
    public ArrayList<Article> NotExpert() {
        String sql = "select * from article where id not in (select articleid from article_idea) ";
        ResultSet rSet = db.getResultSet(st, sql);
        ArrayList<Article> arrayList = new ArrayList<Article>();
        try {
            while (rSet.next()) {
                Article article = new Article();
                Author autor = new Author();
                autor.setAutoname(rSet.getString(2));
                article.setId(rSet.getInt(1));
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
}
