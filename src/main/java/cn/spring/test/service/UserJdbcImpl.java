package cn.spring.test.service;

import cn.spring.entity.User;
import cn.spring.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;

public class UserJdbcImpl extends JdbcTemplate {

    @Override
    public Object doInStatement(ResultSet rs) {
        User user = null;
        try {
            if (rs.next()){
                user = new User();
                user.setAge(rs.getInt("age"));
                user.setName(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
