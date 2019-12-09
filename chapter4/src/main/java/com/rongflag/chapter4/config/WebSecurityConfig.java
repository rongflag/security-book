package com.rongflag.chapter4.config;

import com.rongflag.chapter4.authentication.SecurityAuthenticationFailureHandler;
import com.rongflag.chapter4.authentication.SecurityAuthenticationSuccessHandler;
import com.rongflag.chapter4.filter.VerificationCodeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



/**
 * @author : aihuxi
 * @version V1.0
 * @Project: chapter3
 * @Package com.rongflag.chapter3.config
 * @Description: TODO
 * @email : worongbo@163.com
 * @date 2019年12月06日 22:20
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/api/**").permitAll()
                .antMatchers("/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/myLogin.html")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .cors().and().csrf().disable();

        http.addFilterBefore(new VerificationCodeFilter(),UsernamePasswordAuthenticationFilter.class);
//        http.addFilter()
//        http.addFilterAfter()
//        http.addFilterA
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
