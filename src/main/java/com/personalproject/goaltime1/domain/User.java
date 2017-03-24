package com.personalproject.goaltime1.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "USERROLE",
            joinColumns = @JoinColumn(
                    name = "USERID",
                    referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(
                    name = "ROLEID",
                    referencedColumnName = "ID"))
    private Set<Role> roles;

    //    @NotNull
    //    private boolean enabled = true;
    //
    //    @NotNull
    //    private boolean credentialsexpired = false;
    //
    //    @NotNull
    //    private boolean expired = false;
    //
    //    @NotNull
    //    private boolean locked = false;

    //    @ManyToMany(
    //            fetch = FetchType.EAGER,
    //            cascade = CascadeType.ALL)
    //    @JoinTable(
    //            name = "UserRole",
    //            joinColumns = @JoinColumn(
    //                    name = "userId",
    //                    referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(
    //                    name = "roleId",
    //                    referencedColumnName = "id"))

    //    private Set<Role> roles;

    public User() {

    }



    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    //    //    @Transient
    //    public String getPasswordConfirm() {
    //        return passwordConfirm;
    //    }
    //
    //    public void setPasswordConfirm(String passwordConfirm) {
    //        this.passwordConfirm = passwordConfirm;
    //    }
    /*
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCredentialsexpired() {
        return credentialsexpired;
    }

    public void setCredentialsexpired(boolean credentialsexpired) {
        this.credentialsexpired = credentialsexpired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
     */

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
