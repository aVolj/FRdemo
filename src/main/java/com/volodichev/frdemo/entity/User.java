package com.volodichev.frdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String userName;
    @Column
    private String password;
    @Column(name = "enabled")
    private boolean isEnabled;

    public User(String userName, String password, boolean isEnabled) {
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}