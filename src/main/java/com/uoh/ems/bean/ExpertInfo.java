package com.uoh.ems.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("EXPERTINFO")
public class ExpertInfo {
    private Integer id;
    private String expert_name;//专家名字
    private char expert_sex;//专家性别
    private String expert_nation;//专家民族
    private String expert_political;//政治面貌
    private String expert_work_place;//工作地点
    private String expert_title;//职称
    private String expert_level;//学历
    private String expert_tel;
    @TableField(exist = false)
    private Integer S_CODE;


}
