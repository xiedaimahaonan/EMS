package com.uoh.ems.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: XDS
 * @description: 专家信息实体类
 * @date:2022-9-17
 */
@Data
@TableName("ExpertInfo")
public class ExpertInfo {
    @TableId("E_ID")
    private Integer E_ID ;
    private String EXPERT_NAME;//专家名字
    private char EXPERT_SEX  ;//专家性别
    private String EXPERT_NATION;//专家民族
    private String EXPERT_POLITICAL;//政治面貌
    private String EXPERT_WORK_PLACE;//工作地点
    private String EXPERT_TITLE;//职称
    private String EXPERT_LEVEL ;//学历
    private String EXPERT_TEL;
    @TableField(exist=false)
    private String S_NAME;//专业领域 subject
    @TableField(exist=false)
    private String S_CODE;
    @TableField(exist=false)
    private Integer pageNum;
    @TableField(exist=false)
    private Integer pageSize;


}
