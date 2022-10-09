package com.uoh.ems.controller;


import com.uoh.ems.bean.ExpertInfo;
import com.uoh.ems.bean.Subject;
import com.uoh.ems.dao.ExpertInfoMapper;
import com.uoh.ems.dao.SubjectMapper;
import com.uoh.ems.service.ExpertInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ExpertInfoController {
    @Resource
    private ExpertInfoMapper expertInfoMapper;
    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private ExpertInfoService expertInfoService;
    private List<String> s_CODE;

    /**
     * @parameter: pagNo PagNum
     * @author: XDS
     * @description: 首页数据回显
     * @return: freemarker
     * @date:2020-9-17
     */
    @GetMapping ("/Index")
    public ModelAndView getMessage(ExpertInfo expertInfo){
        ModelAndView mv  = new ModelAndView("index");
        mv= this.getPageData(expertInfo,mv,expertInfo.getE_ID());
        mv.addObject("indexShow", "首页");
        mv.addObject("indexMsg", "专家导航");
        mv.addObject("SpecialAreaMsg",subjectMapper.getSpecialArea());
        mv.addObject("SubjectMsg",subjectMapper.getSubjectMsg());
        mv.addObject("ExpertTitleMsg",expertInfoMapper.getExpertTitle());
        mv.addObject("VisitPersonsMsg",expertInfoMapper.getVisitPersons());
        mv.addObject("ExpertWorkPlace",expertInfoMapper.getExpertWorkPlace());
        return mv;
    }

@RequestMapping(value = "/subjectQuery",method = RequestMethod.POST)
@ResponseBody
public  void getsubjectUpdate(@RequestBody List<String> S_CODE){
for (String item :S_CODE){
    System.out.println(item);
}


}

    /**
     * @parameter: ExpertInfo
     * @author: XDS
     * @description: 搜索框查询数据回显
     * @return: ModelAndView
     * @date: 2022-10-3
     */
    @GetMapping("/IndexQuery")
    public ModelAndView queryMessage(@RequestBody ExpertInfo expertInfo){
        ModelAndView mv = new ModelAndView("index");
        mv = this.getPageData(expertInfo,mv,expertInfo.getE_ID());
        return mv;
    }
    @GetMapping("/IndexLeftQuery/{id}")
    public ModelAndView queryLeftMessage(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("index");
        mv = this.getPageData(new ExpertInfo(),mv,id);
        return mv;
    }

    /**
     * @parameter: ExpertInfo ModelAndView
     * @author: XDS
     * @description: 根据条件查询数据
     * @return: ModelAndView
     * @date:2022-10-3
     */
    public ModelAndView getPageData(ExpertInfo e,ModelAndView mv ,Integer id){
        mv.addObject("PageStarData", expertInfoMapper.getExpertSelfMsg());
        mv.addObject("PageDataList", expertInfoService.getExpertPageMsg(e,id));
        return  mv;

    }
}
