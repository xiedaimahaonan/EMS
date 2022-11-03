package com.uoh.ems.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uoh.ems.bean.Users;
import com.uoh.ems.bean.util.Result;
import com.uoh.ems.dao.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Slf4j
@Controller
public class UserController {
    private ObjectMapper mapper = new ObjectMapper();
    @Resource
    private UsersMapper usersMapper;
    @RequestMapping("/user")
    public ModelAndView login() {
        ModelAndView mv  = new ModelAndView("login");
        return mv ;

    }

    /**
     * @parameter: JSON
     * @author: XDS
     * @description: 校验登录
     * @return: String
     * @date: 2022-9-11
     */
    @PostMapping("/login")
    @ResponseBody
    public Result<String> login(@RequestBody Users uses) throws JsonProcessingException {
        String username = uses.getUsername();
        log.info("用户名：{}",username);
        String password = uses.getPassword();
        log.info("密码：{}",password);
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Users::getUsername,username);
        Users users = usersMapper.selectOne(lambdaQueryWrapper);
        if (users == null) {
            return Result.error("登录失败");
        }
        if (!users.getPassword().equals(password)) {
            return Result.error("登录失败");
        }
        //mapper.writeValueAsString(Result.success("登录成功"));
        return Result.success("登录成功");
    }
   /* @PostMapping("/UserUpdate")
    public void UserUpdate(@ModelAttribute("user") Users user){
        System.out.println(user);
    }*/
}
