package com.hqj.model;

import com.mysql.jdbc.Connection;

import java.sql.*;

public class DB {
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/qikan?user=root&password=123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

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

    public PreparedStatement prepare(Connection conn, String sql,
                                     int autoGenereatedKeys) {
        PreparedStatement pstmt = null;
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(sql, autoGenereatedKeys);
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

    public void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
