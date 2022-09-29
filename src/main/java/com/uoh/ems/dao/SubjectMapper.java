package com.uoh.ems.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uoh.ems.bean.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
    /**
     * @parameter: null
     * @author: XDS
     * @description: SubjectMsg 获取科目信息
     * @return: List<String>
     * @date:
     */
    List<Subject> getSubjectMsg();
}
