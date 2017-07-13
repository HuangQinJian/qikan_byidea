package com.hqj.utils;


import java.sql.*;

/**
 * Created by 11157 on 2017/7/13.
 */
public class DBhelper {
    public PreparedStatement prepare(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }


    public Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(Statement stmt, String sql) {
        try {
            if (stmt != null) {
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
