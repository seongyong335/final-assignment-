package com.set.model.user.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String userId;
    private String userPasswd;

    public UserDTO() {
    }

    public UserDTO(String userId, String userPasswd) {
        this.userId = userId;
        this.userPasswd = userPasswd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                '}';
    }
}
