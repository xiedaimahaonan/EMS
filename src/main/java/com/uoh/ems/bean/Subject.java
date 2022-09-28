package com.uoh.ems.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

@TableName("SUBJECT")
@Data
public class Subject {
    private Integer S_ID;
    private Integer S_CODE;//科目代码
    private  String S_NAME;//科目名
    private String S_COMMENT;//科目备注
}
