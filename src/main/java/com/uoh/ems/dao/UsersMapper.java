package com.uoh.ems.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uoh.ems.bean.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
}
