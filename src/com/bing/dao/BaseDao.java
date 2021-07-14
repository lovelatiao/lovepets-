package com.bing.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    //初始化
    /*static {
        Properties properties = new Properties();
        //通过properties获取资源
        InputStream is =
                BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }*/

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lovepets?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8",
                    "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //查询
    public static ResultSet execute(Connection connection, Object[] params, String sql,
                                    ResultSet resultSet, PreparedStatement ptsm)
            throws SQLException {
        ptsm = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        for (int i = 0; i < params.length; i++) {
            ptsm.setObject(i + 1, params[i]);
        }
        resultSet = ptsm.executeQuery();
        return resultSet;
    }

    //改
    public static int execute(Connection connection, Object[] params, String sql, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    //释放
    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }

        }
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }

        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }

        }
        return flag;
    }
}
