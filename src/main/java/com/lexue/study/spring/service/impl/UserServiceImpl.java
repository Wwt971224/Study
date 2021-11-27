package com.lexue.study.spring.service.impl;

import com.lexue.study.spring.dao.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author wTai
 * @since 2021-11-26
 */
@Service
public class UserServiceImpl {

    @Resource
    private UserDao userDAO;

    @Transactional
    public void insertUser() {
        System.out.println("插入开始");
        userDAO.inset();
        System.out.println("插入完成");
//        int i = 1 / 0;
    }

}
