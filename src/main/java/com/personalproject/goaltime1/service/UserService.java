package com.personalproject.goaltime1.service;

import com.personalproject.goaltime1.domain.User;

public interface UserService {

    void saveUser(User user);

    User findByUsername(String username);

}
