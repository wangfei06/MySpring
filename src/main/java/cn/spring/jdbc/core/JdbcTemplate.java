package cn.spring.jdbc.core;

import java.sql.*;

public abstract class JdbcTemplate {
    public JdbcTemplate(){

    }

    public Object query(String sql){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Object result = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/testdb?characterEncoding=utf8","root","123456");
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            result = doInStatement(rs);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }

                if (statement != null){
                    statement.close();
                }

                if (rs != null){
                    rs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }

    public abstract Object doInStatement(ResultSet rs);
}
