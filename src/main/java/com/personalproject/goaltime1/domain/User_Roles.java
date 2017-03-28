package com.personalproject.goaltime1.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class User_Roles {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_role_id")
    private String user_role_id;

    @Column(name="username")
    private String username;

    @Column(name="role")
    private String role;

    @ManyToMany(mappedBy = "user_roles")
    private Set<Users> users;

}
