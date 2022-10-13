package com.uoh.ems.controller;



import com.github.pagehelper.PageInfo;
import com.uoh.ems.bean.ExpertInfo;
import com.uoh.ems.bean.util.PageInfoUtil;
import com.uoh.ems.dao.ExpertInfoMapper;
import com.uoh.ems.dao.SubjectMapper;
import com.uoh.ems.service.ExpertInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ExpertInfoController {
    @Resource
    private ExpertInfoMapper expertInfoMapper;
    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private ExpertInfoService expertInfoService;

    /**
     * @parameter: pagNo PagNum
     * @author: XDS
     * @description: 首页数据回显
     * @return: freemarker
     * @date:2020-9-17
     */
    @GetMapping ("/Index")
    public ModelAndView getMessage(@ModelAttribute ExpertInfo e){
        ModelAndView mv  = new ModelAndView("index");
        e.setMarker(2);
        if(e.getPageNum()!=null){
            e.setPageNum(e.getPageNum());
        }
        if(e.getPageSize()!=null){
            e.setPageSize(e.getPageNum());
        }
        mv=this.getPageData(e,mv);
        mv.addObject("indexShow", "首页");
        mv.addObject("indexMsg", "专家导航");
        mv.addObject("SpecialAreaMsg",subjectMapper.getSpecialArea());
        mv.addObject("SubjectMsg",subjectMapper.getSubjectMsg());
        mv.addObject("ExpertTitleMsg",expertInfoMapper.getExpertTitle());
        mv.addObject("VisitPersonsMsg",expertInfoMapper.getVisitPersons());
        mv.addObject("ExpertWorkPlace",expertInfoMapper.getExpertWorkPlace());
        return mv;
    }


    /**
     * @parameter: ExpertInfo
     * @author: XDS
     * @description: 搜索框查询数据回显
     * @return: ModelAndView
     * @date: 2022-10-3
     */
    //http://localhost:8088/IndexQuery
    @PostMapping("/IndexQuery")
    public ModelAndView queryMessage(@ModelAttribute("expertInfo") ExpertInfo expertInfo){
        expertInfo.setMarker(2);
        ModelAndView mv = new ModelAndView("index_list");
        mv = getPageData(expertInfo,mv);
        return mv;
    }
    @GetMapping("/IndexLeftQuery_{id}")
    public ModelAndView queryLeftMessage(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("indexShow", "首页");
        mv.addObject("indexMsg", "专家导航");
        mv.addObject("SpecialAreaMsg",subjectMapper.getSpecialArea());
        mv.addObject("SubjectMsg",subjectMapper.getSubjectMsg());
        mv.addObject("ExpertTitleMsg",expertInfoMapper.getExpertTitle());
        mv.addObject("VisitPersonsMsg",expertInfoMapper.getVisitPersons());
        mv.addObject("ExpertWorkPlace",expertInfoMapper.getExpertWorkPlace());
        ExpertInfo e = new ExpertInfo();
        e.setMarker(2);
        if(String.valueOf(id).length()==4){
            e.setS_CODE(String.valueOf(id));
        }else{
            e.setE_ID(id);
        }
        mv = getPageData(e,mv);
        return mv;
    }

    /**
     * @parameter: CODE
     * @author: XDS
     * @description: 多科目查询
     * @return: List
     * @date:2022-10-7
     */
    @PostMapping("/subjectQuery")
    public ModelAndView subjectQuery(@RequestBody List<String> id){
        ModelAndView mv  = new ModelAndView("index_list");
        ExpertInfo e = new ExpertInfo();
        List<Integer> list = new ArrayList<>();
        for (String s : id) {
            list.add(Integer.valueOf(s));
        }
        e.setMarker(1);
        if(e.getPageNum()==null){
            e.setPageNum(1);
        }
        if(e.getPageSize()==null){
            e.setPageSize(3);
        }
        PageInfo pageInfo = PageInfoUtil.PageHelper(e, expertInfoService.doQueryList(e, list));
        mv.addObject("PageStarData",pageInfo.getList());
        mv.addObject("ThePageInfo",pageInfo);
        return mv;

    }

    /**
     * @parameter: null
     * @author: XDS
     * @description: 专家成果视图
     * @return:  MainResult.html
     * @date:2022-10-8
     */
    @GetMapping("/expertResult")
    public ModelAndView expertResult(){
        ModelAndView mv = new ModelAndView("MainResult");
        return mv;
    }


    /**
     * @parameter: ExpertInfo ModelAndView
     * @author: XDS
     * @description: 根据条件查询数据
     * @return: ModelAndView
     * @date:2022-10-3
     */
    public ModelAndView getPageData(ExpertInfo e,ModelAndView mv){
        Map<String, Object> expertPageMsg = expertInfoService.getExpertPageMsg(e);
        mv.addObject("PageStarData",expertPageMsg.get("pageData"));
        mv.addObject("ThePageInfo", expertPageMsg.get("pageInfo"));
        return  mv;

    }
}
