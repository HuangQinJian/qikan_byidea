package com.hqj.serviceimpl;

import com.hqj.model.Article;
import com.hqj.model.DB;
import com.hqj.model.Editor;
import com.hqj.service.EditorService;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EditorServiceImpl implements EditorService {
    private static EditorServiceImpl eImpl = null;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public static EditorServiceImpl getInstance() {
        if (eImpl == null) {
            //logger.info("第一次初始化EditorServiceImpl");
            // System.out.println("第一次初始化EditorServiceImpl");
            eImpl = new EditorServiceImpl();
        }
        return eImpl;
    }

    Connection conn = DB.getConn();
    Statement st = DB.getStatement(conn);
    private PreparedStatement pstmt = null;

    /*
     * (non-Javadoc)
     * 编辑者添加文章
     * @see com.hqj.service.EditorService#addarticle(com.hqj.model.Article)
     */
    @Override
    public boolean addarticle(Article article) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *  更新文章
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
     * 删除文章
     * @see com.hqj.service.EditorService#delarticle(com.hqj.model.Article)
     */
    @Override
    public boolean delarticle(Article article) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *  添加编辑者用户信息
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
                logger.info("查询时的sql语句是" + sql);
                //System.out.println("查询时的sql语句是" + sql);
                // System.out.println("yes");
                return true;
            } else {
                logger.error("编辑者信息添加失败!");
                // System.out.println("no");
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
     * 编辑者登录
     * @see com.hqj.service.EditorService#search(java.lang.String,
     * java.lang.String)
     */
    @Override
    public boolean search(String name, String password) {
        // TODO Auto-generated method stub
        String sql = "select * from editor";
        logger.info("编辑者查询时的sql语句是" + sql);
        //System.out.println("查询时的sql语句是" + sql);
        ResultSet rSet = DB.getResultSet(st, sql);
        int index = 0;
        try {
            while (rSet.next()) {
                if (rSet.getString(2).equals(name)
                        && rSet.getString(3).equals(password)) {
                    logger.info("编辑者登录成功！");
                    //System.out.println("登录成功");
                    index = 1;
                    break;
                } else {
                    logger.info("编辑者登录失败！");
                    logger.error("您输入的用户名或者密码不正确，请重新输入!");
                    //System.out.println("您输入的用户名或者密码不正确，请重新输入!");
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
