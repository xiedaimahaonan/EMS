package com.uoh.ems.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.annotation.Resource;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;//用其实现用户名密码的获取

    /**
     * @parameter:null
     * @author: XDS
     * @description: 自定义数据库获取的用户名密码 解码
     * @return:nulll
     * @date:2022-10-2
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    /**
     * @parameter:null
     * @author: XDS
     * @description: PasswordEncoder加密码接口对象 对比UserDetails密码
     * @return: BCryptPasswordEncoder()
     */
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    /**
     * @parameter: http
     * @author: XDS
     * @description: 自定义登录
     * @return:null
     * @date:
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //没有权限访问页面
        http.exceptionHandling().accessDeniedPage("/error.html");
        //允许iframe页面嵌套
        http.headers().frameOptions().disable();
        //自定义自己登录页面
        http.formLogin()
                .loginPage("/Login") //登录页面
                .loginProcessingUrl("/doLogin") // 登录接口 security
                //.successForwardUrl("/Index")//登录成功页面
                .successHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    String _RS = "{\"msg\":\"登录成功\", \"objid\":\"" + authentication.getName() + "\"}";
                    out.write(_RS);
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    String _RS = "{\"msg\":\"登录失败\", \"objid\":\"" + e.getMessage() + "\"}";
                    out.write(_RS);
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and().authorizeRequests()//定义路径访问权限
                .antMatchers( "/css/**","/file/**","/img/**","/lib/**")
                .permitAll()
                .antMatchers("/Login").permitAll() //设置不需要认证登录的直接访问路径
                .anyRequest().authenticated();//任何路径都可以访问


    }
    //配置js,css,图片等静态资源
  /*  @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/js/**", "/css/**","/file/**","/img/**","/lib/**");
    }*/


}
