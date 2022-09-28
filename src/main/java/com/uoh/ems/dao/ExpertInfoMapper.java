package com.uoh.ems.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uoh.ems.bean.ExpertInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExpertInfoMapper extends BaseMapper<ExpertInfo> {
    void selectMsg(@Param("page")Page<ExpertInfo> page, @Param("expertInfo") ExpertInfo expertInfo);
    List<String> getExpertTitle();

    List<String> getVisitPersons();

    List<String> getSpecialArea();

    List<String> getExpertWorkPlace();

    List<String> getSubjectMsg();
}
