package com.personalproject.goaltime1.service;

import com.personalproject.goaltime1.domain.User;

public interface AccountService {

    User findByUsername(String username);
}
