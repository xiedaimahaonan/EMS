package com.uoh.ems.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.uoh.ems.bean.Users;
import com.uoh.ems.common.Result;
import com.uoh.ems.dao.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Controller
public class UserController {
    @Autowired
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
    public Result<String> login(@RequestBody Users uses){
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
        return Result.success("登录成功");
    }

}
