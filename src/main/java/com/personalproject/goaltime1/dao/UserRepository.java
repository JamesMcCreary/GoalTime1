package com.personalproject.goaltime1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalproject.goaltime1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
}
