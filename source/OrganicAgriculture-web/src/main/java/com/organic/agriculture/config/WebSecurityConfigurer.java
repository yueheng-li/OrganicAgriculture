package com.organic.agriculture.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/index").permitAll()
//                .anyRequest().authenticated().and().csrf().disable();
        http.csrf().disable();
    }
}
