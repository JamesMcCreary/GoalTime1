package com.personalproject.goaltime1.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personalproject.goaltime1.domain.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String>{

    List<Users> findAll();
    public Users findByUsername(String username);
}
