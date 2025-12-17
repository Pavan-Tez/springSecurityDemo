package com.sec.springSecurityDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sec.springSecurityDemo.entity.UserEntity;
import com.sec.springSecurityDemo.repository.UserRepository;

@Service
public class SecurityService implements UserDetailsService{

    private final UserRepository repository;
    
    @Autowired
    public SecurityService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUserName(username).orElseThrow(() -> new RuntimeException("Invalid User name or Password"));
    
        return User.builder().username(user.getUserName())
                             .password("{noop}"+user.getPassword())
                             .roles(user.getRole().name())
                             .build();
    } 
}
