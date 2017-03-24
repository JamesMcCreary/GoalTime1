package com.personalproject.goaltime1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalproject.goaltime1.dao.UserRepository;
import com.personalproject.goaltime1.domain.User;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository userJpaDao;

    @Override
    public User findByUsername(String username) {
        User user = userJpaDao.findByUsername(username);
        return user;
    }



}

