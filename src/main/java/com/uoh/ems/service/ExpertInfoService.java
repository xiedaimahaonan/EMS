package com.uoh.ems.service;



import com.github.pagehelper.PageInfo;
import com.uoh.ems.bean.ExpertInfo;
import com.uoh.ems.bean.util.PageInfoUtil;
import com.uoh.ems.dao.ExpertInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;



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
    public Map<String,Object> getExpertPageMsg(ExpertInfo e ) {
        Map map = new HashMap<>();
        if(e.getPageNum()==null){
            e.setPageNum(1);
        }
        if(e.getPageSize()==null){
            e.setPageSize(2);
        }
        List<ExpertInfo> list = this.doQueryList(e, new ArrayList<>());
        PageInfo pageMsg = PageInfoUtil.PageHelper(e, list);
        map.put("pageData",pageMsg.getList());
        map.put("pageInfo",pageMsg);
        return map;

    }

    /**
     * @parameter: ExpertInfo
     * @author: XDS
     * @description:多个专家多科目归并
     * @return: List<ExpertInfo>
     * @date:2022-10-6
     */
    public List<ExpertInfo> doQueryList(ExpertInfo e,List<Integer> s_id) {
        List<ExpertInfo> expertList;
        if (e.getMarker() == 2) {
            expertList = expertInfoMapper.getExpertPageData(e);
        } else {
            expertList = expertInfoMapper.subjectQuery(s_id);
        }
        List<ExpertInfo> list = new ArrayList<>();
        Map<Integer, ExpertInfo> map = new HashMap<>();
        for (int i = 0; i < expertList.size(); i++) {
            Integer e_id = expertList.get(i).getE_ID();
            if (map.containsKey(e_id)) {
                ExpertInfo expert = new ExpertInfo();
                expert.setE_ID(e_id);
                expert.setEXPERT_NAME(expertList.get(e_id).getEXPERT_NAME());
                expert.setEXPERT_LEVEL(expertList.get(e_id).getEXPERT_LEVEL());
                expert.setEXPERT_SEX(expertList.get(e_id).getEXPERT_SEX());
                expert.setEXPERT_POLITICAL(expertList.get(e_id).getEXPERT_POLITICAL());
                expert.setEXPERT_WORK_PLACE(expertList.get(e_id).getEXPERT_WORK_PLACE());
                expert.setEXPERT_TITLE(expertList.get(e_id).getEXPERT_TITLE());
                expert.setEXPERT_NATION(expertList.get(e_id).getEXPERT_NATION());
                expert.setEXPERT_TEL(expertList.get(e_id).getEXPERT_TEL());
                expert.setS_CODE(expertList.get(e_id).getS_CODE());
                expert.setPageNum(expertList.get(e_id).getPageNum());
                expert.setPageSize(expertList.get(e_id).getPageSize());
                expert.setS_NAME(map.get(e_id).getS_NAME() + " " + expertList.get(i).getS_NAME());
                map.put(e_id, expert);
            } else {
                map.put(e_id, expertList.get(i));
            }
        }
        for (Integer expertInfo : map.keySet()) {
            list.add(map.get(expertInfo));
        }
        return list;

    }



}
