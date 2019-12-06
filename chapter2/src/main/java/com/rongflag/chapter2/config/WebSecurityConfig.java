package com.rongflag.chapter2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @author : aihuxi
 * @version V1.0
 * @Project: chapter2
 * @Package com.rongflag.chapter2.inmemory
 * @Description: TODO
 * @email : worongbo@163.com
 * @date 2019年12月06日 18:51
 */
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/app/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("123").roles("user").build());
//        manager.createUser(User.withUsername("admin").password("123").roles("user", "admin").build());
//        return manager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    private DataSource dataSource;
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        manager.createUser(User.withUsername("user").password("123").roles("user").build());
        manager.createUser(User.withUsername("admin").password("123").roles("user", "admin").build());
        return manager;
    }


}
