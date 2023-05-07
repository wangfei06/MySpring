package cn.spring.test.service;

import cn.spring.entity.User;
import cn.spring.jdbc.core.JdbcTemplate;

public class UserService {
    public User getUserInfo() {
        String sql = "select * from user ";
        JdbcTemplate jdbcTemplate = new UserJdbcImpl();
        User rtnUser = (User)jdbcTemplate.query(sql);
        return rtnUser;
    }
}
