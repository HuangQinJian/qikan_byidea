/**
 *
 */
package com.hqj.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hqj.model.Article;
import com.hqj.model.DB;
import com.hqj.model.Editor;
import com.hqj.service.EditorService;
import com.mysql.jdbc.Connection;


public class EditorServiceImpl implements EditorService {
    private EditorServiceImpl eImpl = null;

    public EditorServiceImpl getInstance() {
        if (eImpl == null) {
            System.out.println("第一次初始化EditorServiceImpl");
            eImpl = new EditorServiceImpl();
        }
        return eImpl;
    }

    Connection conn = DB.getConn();
    Statement st = DB.getStatement(conn);
    private PreparedStatement pstmt = null;

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.EditorService#addarticle(com.hqj.model.Article)
     */
    @Override
    public boolean addarticle(Article article) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.EditorService#updatearticle(com.hqj.model.Article)
     */
    @Override
    public boolean updatearticle(int id, String editorname, String editordetail, java.util.Date editortime) {
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        if (articleService.getInstance().editorarticle(id, editorname, editordetail, editortime))
            return true;
        else
            return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.EditorService#delarticle(com.hqj.model.Article)
     */
    @Override
    public boolean delarticle(Article article) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.hqj.service.EditorService#add(com.hqj.model.Editor)
     */
    @Override
    public boolean add(Editor editor) {
        // TODO Auto-generated method stub
        String sql = "insert into editor(name,password) values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, editor.getEditname());
            pstmt.setString(2, editor.getEditpass());
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
     * @see com.hqj.service.EditorService#search(java.lang.String,
     * java.lang.String)
     */
    @Override
    public boolean search(String name, String password) {
        // TODO Auto-generated method stub
        String sql = "select * from editor";
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
}
