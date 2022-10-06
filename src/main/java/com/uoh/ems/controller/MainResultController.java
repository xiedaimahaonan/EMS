package com.uoh.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainResultController {
    @RequestMapping("/MainResult")
     public ModelAndView MainResult(){
         ModelAndView mv  = new ModelAndView("MainResult");
         return mv ;
     }
}
