package com.uoh.ems.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.uoh.ems.bean.Users;
import com.uoh.ems.dao.UsersMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author: XDS
 * @description: 自定义数据库密码查询 实现UserDetails接口
 * @date:2022-10-6
 */
/*@Service("userDetailsService")
public class QueryUserDetailsService implements UserDetailsService {
    @Resource
    private UsersMapper userMapper;

    /**
     * @parameter: String username
     * @author: XDS
     * @description: 返回数据库 查询用户名密码
     * @return: UserDetails
     */

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper<Users>();
        lambdaQueryWrapper.eq(Users::getUsername,username);
        Users users = userMapper.selectOne(lambdaQueryWrapper);
        if(users==null){
            throw new UsernameNotFoundException("用户名密码不存在");
        }
        List<GrantedAuthority> author = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");//设置角色admin
        return new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), author);
    }
}*/

