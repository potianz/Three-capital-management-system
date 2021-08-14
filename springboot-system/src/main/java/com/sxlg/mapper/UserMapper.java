package com.sxlg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxlg.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select id,name,password from user where name=#{name} ")
     User selectUser(@Param("name") String name);
}
