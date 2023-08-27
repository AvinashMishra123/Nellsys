package com.example.NellsysServerApplicant.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
//@PreAuthorize("@somePermissionEvaluatorBean.hasPermission(authentication, ...")
public class  SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/bikes/**").authenticated()
                .antMatchers("/drivers/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic(); // Use basic authentication
    }
}
