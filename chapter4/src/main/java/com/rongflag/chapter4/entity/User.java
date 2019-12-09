package com.rongflag.chapter4.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author : aihuxi
 * @version V1.0
 * @Project: chapter3
 * @Package com.rongflag.chapter3.config.entity
 * @Description: TODO
 * @email : worongbo@163.com
 * @date 2019年12月06日 22:29
 */
@Data
public class User  implements UserDetails{

    private Long id;

    private String username;

    private String password;

    private boolean enabled;

    private String roles;

    private List<GrantedAuthority> authorities;

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities( List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
