/**
 *
 */
package com.hqj.serviceimpl;


import com.hqj.model.Article;
import com.hqj.model.DB;
import com.hqj.model.Expert;
import com.hqj.service.ExpertService;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExpertServiceImpl implements ExpertService {
    private ExpertServiceImpl expertService = null;

    public ExpertServiceImpl getInstance() {
        if (expertService == null) {
            System.out.println("第一次初始化ExpertServiceImpl");
            expertService = new ExpertServiceImpl();
        }
        return expertService;
    }

    Connection conn = DB.getConn();
    Statement st = DB.getStatement(conn);
    private PreparedStatement pstmt = null;

    @Override
    public boolean add(Expert expert) {
        String sql = "insert into expert(name,password) values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, expert.getExpename());
            pstmt.setString(2, expert.getExpepass());
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

    @Override
    public boolean search(String name, String password) {
        String sql = "select * from expert";
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

    @Override
    public boolean addarticle(Article article) {
        return false;
    }

    @Override
    public boolean updatearticle(Article article) {
        return false;
    }

    @Override
    public boolean delarticle(Article article) {
        return false;
    }
}
