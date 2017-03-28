package com.personalproject.goaltime1.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id")
    private Set<User_Roles> user_roles;

    public Users() {
        super();
    }

    public Users(String username, String password, Boolean enabled, Set<User_Roles> user_roles) {
        super();
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.user_roles = user_roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<User_Roles> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(Set<User_Roles> user_roles) {
        this.user_roles = user_roles;
    }




}
