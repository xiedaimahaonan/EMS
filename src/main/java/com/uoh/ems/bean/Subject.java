package com.uoh.ems.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author: XDS
 * @description: 科目信息实体类
 * @date:2022-9-25
 */
@TableName("Subject")
@Data
public class Subject {
    private Integer S_ID;//科目ID
    private Integer S_CODE;//科目代码
    private  String S_NAME;//科目名
    private String S_COMMENT;//科目备注
}
