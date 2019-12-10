package com.rongflag.chapter5.service;

import com.rongflag.chapter5.entity.User;
import com.rongflag.chapter5.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : aihuxi
 * @version V1.0
 * @Project: chapter3
 * @Package com.rongflag.chapter3.service
 * @Description: TODO
 * @email : worongbo@163.com
 * @date 2019年12月06日 22:44
 */
@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersMapper.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("未找到该用户："+username);
        }
        String roles = user.getRoles();
        List<GrantedAuthority> grantedAuthorities = this.createAuthorities(roles);
//        系统自带的转换权限 但是用自己的更好控制
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles());
        user.setAuthorities(grantedAuthorities);

        return user;
    }

    /***
     * @Descripton 自行转换权限
     * @param
     * @rerturn 
     * @date  
     * @auther aihuxi
     */
      
    private List<GrantedAuthority> createAuthorities(String roles) {
        List<GrantedAuthority>lists = new ArrayList<>();
        if(roles != null && !"".equals(roles)){
            String[] roleArr = roles.split(",");
            for (String role:roleArr ){
                lists.add(new SimpleGrantedAuthority(role));
            }
        }
        return lists;
    }


}
