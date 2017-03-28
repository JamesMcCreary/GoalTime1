package com.personalproject.goaltime1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personalproject.goaltime1.domain.User_Roles;

@Repository
public interface UserRolesRepository extends CrudRepository<User_Roles, Long> {

    @Query("select ur.role from User_Roles ur, Users u where u.username=?1 and ur.username=u.username")
    public List<String> findRoleByUserName(String username);

}