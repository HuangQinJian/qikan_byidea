package com.hqj.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by 11157 on 2017/7/13.
 */
public class C3p0Utils {
    private static Logger logger = Logger.getLogger(C3p0Utils.class.getName());
    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    //从连接池中取用一个连接
    public static Connection getConnection() {
        try {
            logger.info("连接成功！");
            return dataSource.getConnection();
        } catch (Exception e) {
            logger.error("Exception in C3p0Utils!", e);
        }
        return null;
    }

    //释放连接回连接池
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("Exception in C3p0Utils!", e);
            }
        }
    }
}
