package com.rongflag.chapter3.mapper;

import com.rongflag.chapter3.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author : aihuxi
 * @version V1.0
 * @Project: chapter3
 * @Package com.rongflag.chapter3.mapper
 * @Description: TODO
 * @email : worongbo@163.com
 * @date 2019年12月06日 22:38
 */
@Component
public interface UsersMapper {

    @Select("select * from users2 where username=#{username}")
    User getUserByUsername(@Param("username") String username);
}
