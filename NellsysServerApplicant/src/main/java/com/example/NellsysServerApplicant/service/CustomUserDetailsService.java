package com.example.NellsysServerApplicant.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement fetching user details from your data source
        // For simplicity, you can return a hard-coded user here
        return User.withUsername("user")
                .password("{noop}password") // {noop} indicates plain text password
                .roles("USER")
                .build();
    }
}
