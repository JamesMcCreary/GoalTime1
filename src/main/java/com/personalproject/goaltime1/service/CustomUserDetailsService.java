package com.personalproject.goaltime1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.personalproject.goaltime1.dao.UserRolesRepository;
import com.personalproject.goaltime1.dao.UsersRepository;
import com.personalproject.goaltime1.domain.CustomUserDetails;
import com.personalproject.goaltime1.domain.Users;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository,UserRolesRepository userRolesRepository) {
        this.usersRepository = usersRepository;
        this.userRolesRepository = userRolesRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);

        if(null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            return new CustomUserDetails(user,userRoles);
        }
    }
}