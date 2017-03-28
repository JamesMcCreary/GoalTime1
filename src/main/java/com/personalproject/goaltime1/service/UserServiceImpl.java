package com.personalproject.goaltime1.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.personalproject.goaltime1.dao.RoleRepository;
import com.personalproject.goaltime1.dao.UserRepository;
import com.personalproject.goaltime1.domain.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //    @Autowired
    //    private PasswordEncoder passwordencoder;

    @Override
    public void saveUser(User user) {
        String password = user.getPassword();
        System.out.println(password);
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        System.out.println(encryptedPassword);
        user.setPassword(user.getPassword());
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        System.out.println(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
