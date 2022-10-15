package com.uoh.ems.controller;
import com.uoh.ems.bean.Users;
import com.uoh.ems.dao.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Slf4j
@Controller
public class UserController {
    @Resource
    private UsersMapper usersMapper;

    @GetMapping("/Login")
    public ModelAndView login() {
        ModelAndView mv  = new ModelAndView("login");
        return mv ;
    }

    @PostMapping("/UserUpdate")
    public void UserUpdate(@ModelAttribute("user") Users user){
        System.out.println(user);
    }
}
