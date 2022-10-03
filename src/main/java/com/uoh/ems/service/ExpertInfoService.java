package com.uoh.ems.service;

import com.github.pagehelper.PageInfo;
import com.uoh.ems.bean.ExpertInfo;
import com.uoh.ems.dao.ExpertInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: XDS
 * @description: 专业信息业务层
 * @date:2022-10-3
 */
@Service
public class ExpertInfoService {
    @Resource
    private ExpertInfoMapper expertInfoMapper;
    /**
     * @parameter: ExpertInfo
     * @author: XDS
     * @description: 根据条件查数据分页回显
     * @return: Map
     * @date:2022-10-3
     */
    public PageInfo<ExpertInfo> getExpertPageMsg(ExpertInfo e,Integer id) {
        if(e.getPageNum()==null){
            e.setPageNum(1);
        }
        if(e.getPageSize()==null){
            e.setPageSize(5);
        }
        PageInfo<ExpertInfo> pages = new PageInfo<>(expertInfoMapper.getExpertPageData(e,id),e.getPageNum());
        return pages;
    }
}
