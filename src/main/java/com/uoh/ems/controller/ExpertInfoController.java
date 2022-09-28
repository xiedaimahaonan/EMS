package com.uoh.ems.controller;


import com.uoh.ems.dao.ExpertInfoMapper;
import com.uoh.ems.dao.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExpertInfoController {
    @Autowired
    private ExpertInfoMapper expertInfoMapper;
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * @parameter: pagNo PagNum
     * @author: XDS
     * @description: 首页数据回显
     * @return: freemarker
     * @date:2020-9-17
     */
    @RequestMapping("/Index")
    public ModelAndView getMessage(@RequestParam(value = "PageNo", required = false) Integer PageNo, @RequestParam(value = "PageSize", required = false) Integer PageSize){
        ModelAndView mv  = new ModelAndView("index");
        mv.addObject("indexShow", "首页");
        mv.addObject("indexMsg", "专家导航");
        mv.addObject("SpecialAreaMsg",expertInfoMapper.getSpecialArea());
        //mv.addObject("SubjectMsg",subjectMapper.getSubjectMsg());
        mv.addObject("SubjectMsg",expertInfoMapper.getSubjectMsg());
        mv.addObject("ExpertTitleMsg",expertInfoMapper.getExpertTitle());
        mv.addObject("VisitPersonsMsg",expertInfoMapper.getVisitPersons());
        mv.addObject("ExpertWorkPlace",expertInfoMapper.getExpertWorkPlace());
        return mv;
    }
}
