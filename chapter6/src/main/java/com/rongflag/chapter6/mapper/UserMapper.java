package com.rongflag.chapter6.mapper;

import com.rongflag.chapter6.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT * FROM users2 WHERE username=#{username}")
    User findByUserName(@Param("username") String username);

}
