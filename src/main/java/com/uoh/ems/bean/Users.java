package com.uoh.ems.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("USERS")
public class Users {
    private String username ;
    private String password;
    private String user_type ;//用户类型
}
