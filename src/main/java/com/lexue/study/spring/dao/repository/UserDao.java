package com.lexue.study.spring.dao.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author wTai
 * @since 2021-11-26
 */
@Repository
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    public void inset() {
        String sql = "INSERT INTO wwt.user (real_name, le_id, user_mobile) VALUES ('小明', ?, ?);";
        String leId = String.valueOf(new Random().nextInt(1000));

        StringBuilder str = new StringBuilder(11).append(1);
        for (int i = 0; i < 10; i++) {
            str.append(new Random().nextInt(10));
        }
        Long mobile = Long.valueOf(str.toString());
        jdbcTemplate.update(sql,leId,mobile);
    }

}
