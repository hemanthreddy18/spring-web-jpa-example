package com.learning.spring.workshop.model;

public enum  UserProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    private String userProfileType;

    UserProfileType(String user) {
    }

    public String getUserProfileType() {
        return userProfileType;
    }

    public void setUserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }



}
