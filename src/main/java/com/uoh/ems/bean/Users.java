package com.uoh.ems.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: XDS
 * @description: 登录用户信息实体类
 * @date:2022-9-17
 */
@Data
@TableName("USERS")
public class Users {
    private String username; ;//用户名
    private String password;//用户密码
    private String user_type;//用户类型
    //private String NewPassword;//新密码
    //private String renewpassword;//确定新密码
}
