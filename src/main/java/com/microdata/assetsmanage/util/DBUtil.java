package com.microdata.assetsmanage.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Longder on 2016/9/5.
 */
public class DBUtil {
    private static ThreadLocal<Connection> connectionLocal = new ThreadLocal<Connection>();
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties prop = new Properties();
        try {
            prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection getCon() throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds.getConnection();
    }

    public static Connection getConnection() throws SQLException {
        Connection con = connectionLocal.get();
        if (con == null) {
            con = getCon();
            connectionLocal.set(con);
        }
        return con;
    }

    public static void closeConnection() {
        Connection con = connectionLocal.get();
        if (con != null) {
            try {
                con.close();
                connectionLocal.set(null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

