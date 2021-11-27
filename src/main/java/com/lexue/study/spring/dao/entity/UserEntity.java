package com.lexue.study.spring.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
