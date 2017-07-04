/**
 *
 */
package com.hqj.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hqj.model.Article;
import com.hqj.model.Author;
import com.hqj.model.DB;
import com.hqj.service.AuthorService;
import com.mysql.jdbc.Connection;


public class AuthorServiceImpl implements AuthorService {
    private AuthorServiceImpl aImpl = null;

    public AuthorServiceImpl getInstance() {
        if (aImpl == null) {
            System.out.println("第一次初始化AuthorServiceImpl");
            aImpl = new AuthorServiceImpl();
        }
        return aImpl;
    }

    Connection conn = DB.getConn();
    Statement st = DB.getStatement(conn);
    private PreparedStatement pstmt = null;

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.AuthorService#add(com.hqj.model.Author)
     */
    @Override
    public boolean add(Author author) {
        String sql = "insert into author(name,password) values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, author.getAutoname());
            pstmt.setString(2, author.getAutopass());
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
     * @see com.hqj.service.AuthorService#delete(com.hqj.model.Author)
     */
    @Override
    public boolean delete(Author author) {
        String sql = "delete from author where name=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, author.getAutoname());
            if (pstmt.executeUpdate() == 1) {
                System.out.println("删除时的sql语句是" + sql);
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
     * @see com.hqj.service.AuthorService#update(com.hqj.model.Author)
     */
    @Override
    public boolean update(Author author) {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.AuthorService#search(java.lang.String,
     * java.lang.String)
     */
    @Override
    public boolean search(String name, String password) {
        // TODO Auto-generated method stub
        String sql = "select * from author";
        System.out.println("查询时的sql语句是" + sql);
        ResultSet rSet = DB.getResultSet(st, sql);
        int index = 0;
        try {
            while (rSet.next()) {
                if (rSet.getString(2).equals(name)
                        && rSet.getString(3).equals(password)) {
                    System.out.println("登录成功");
                    index = 1;
                    break;
                } else {
                    System.out.println("您输入的用户名或者密码不正确，请重新输入!");
                    index = 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (index == 1) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.AuthorService#addArticle(com.hqj.model.Article)
     */
    @Override
    public boolean addArticle(Article article) {
        // TODO Auto-generated method stub
        ArticleServiceImpl aImpl = new ArticleServiceImpl();
        if (aImpl.addarticle(article)) {
            System.out.println("yes");
            return true;
        }
        return false;
    }
}
