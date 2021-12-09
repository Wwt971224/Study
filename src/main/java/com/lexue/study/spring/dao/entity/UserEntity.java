package com.lexue.study.spring.dao.entity;

import java.io.Serializable;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author wTai
 * @since 2021-11-26
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键用户id
     */
    private Long userId;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 乐学id
     */
    private String leId;

    /**
     * 用户手机号
     */
    private Long userMobile;


}
