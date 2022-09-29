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

    /**
     * @parameter: null
     * @author: XDS
     * @description:ExpertTitleMsg 获取专家职称信息
     * @return:  List<String>
     * @date:2022-9-27
     */
    List<String> getExpertTitle();

    /**
     * @parameter:null
     * @author: XDS
     * @description: VisitPersonsMsg 获取顾问团信息
     * @return: List<String>
     * @date:2022-9-28
     */
    List<String> getVisitPersons();

    /**
     * @parameter:null
     * @author: XDS
     * @description: SpecialArea 获取专家领域信息
     * @return: List<String>
     * @date:2022-9-27
     */
    List<String> getSpecialArea();

    /**
     * @parameter:null
     * @author: XDS
     * @description: ExpertWorkPlace 获取专家机构信息
     * @return: List<String>
     * @date:2022-9-27
     */
    List<String> getExpertWorkPlace();



    /**
     * @parameter: null
     * @author: XDS
     * @description: ExpertSelfMsg 获取专家个人信息
     * @return:  List<ExpertInfo>
     * @date:2022-9-27
     */
    List<ExpertInfo> getExpertSelfMsg();


}
