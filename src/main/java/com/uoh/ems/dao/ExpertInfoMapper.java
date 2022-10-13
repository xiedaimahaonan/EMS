package com.uoh.ems.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uoh.ems.bean.ExpertInfo;
import com.uoh.ems.bean.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExpertInfoMapper extends BaseMapper<ExpertInfo> {

    /**
     * @parameter: null
     * @author: XDS
     * @description:ExpertTitleMsg 获取专家职称信息
     * @return:  List<String>
     * @date:2022-9-27
     */
    List<ExpertInfo> getExpertTitle();

    /**
     * @parameter:null
     * @author: XDS
     * @description: VisitPersonsMsg 获取顾问团信息
     * @return: List<String>
     * @date:2022-9-28
     */
    List<ExpertInfo> getVisitPersons();


    /**
     * @parameter:null
     * @author: XDS
     * @description: ExpertWorkPlace 获取专家机构信息
     * @return: List<String>
     * @date:2022-9-27
     */
    List<ExpertInfo> getExpertWorkPlace();



    /**
     * @parameter: null
     * @author: XDS
     * @description: ExpertSelfMsg 获取专家个人信息
     * @return:  List<ExpertInfo>
     * @date:2022-9-27
     */
    List<ExpertInfo> getExpertSelfMsg();


    /**
     * @parameter:
     * @author: XDS
     * @description:  分页
     * @return: 2022-10-3
     * @date:
     */
    List<ExpertInfo> getExpertPageData(@Param("expert") ExpertInfo expert);


    List<ExpertInfo> subjectQuery(@Param("code")List<Integer> s_id);
    List<ExpertInfo> EIDQuery(Integer E_ID);
}
