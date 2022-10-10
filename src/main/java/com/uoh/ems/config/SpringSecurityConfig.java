package com.uoh.ems.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import javax.annotation.Resource;

import java.io.PrintWriter;

/*@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;//用其实现用户名密码的获取

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    /**
     * @parameter:
     * @author: XDS
     * @description: PasswordEncoder加密码接口对象 对比UserDetails密码
     * @return: BCryptPasswordEncoder()
     */
    /*@Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //没有权限访问页面
        http.exceptionHandling().accessDeniedPage("/error.html");
        //允许iframe页面嵌套
        http.headers().frameOptions().disable();
        //自定义自己登录页面
        http.formLogin()
                .loginPage("/user") //登录页面
                .loginProcessingUrl("/doLogin") // security内部接口
                .successForwardUrl("/Index")//成功页面
                .failureForwardUrl("/user") //失败地址
                .usernameParameter("username")//登录参数
                .passwordParameter("password")
                .permitAll()
                .successHandler((req, resp, authentication) -> {//响应信息
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();//字符
                    String RS = "{\"msg\":\"登录成功\", \"objid\":\"" + authentication.getName() + "\"}";
                    out.write(RS);
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {//响应信息
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    String RS = "{\"msg\":\"登录失败\", \"objid\":\"" + e.getMessage() + "\"}";
                    out.write(RS);
                    out.flush();
                    out.close();
                })
                .and().authorizeRequests()
                .antMatchers("/user").permitAll() //设置不需要认证登录的直接访问路径
                .antMatchers("/index","/IndexQuery","/IndexLeftQuery/*","/subjectQuery","/expertResult").hasAnyAuthority("admin")
                .anyRequest().authenticated()
                .and().csrf().disable();// 关闭 csrf 防护

    }
    //配置js,css,图片等静态资源
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/js/**", "/css/**","/file/**","/img/**","/lib/**");
    }


}*/
