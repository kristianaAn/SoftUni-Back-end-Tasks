package com.softuni.mobilele.domain.beans;

public class LoggedUser {
    private long id;
    private String username;
    private String firstName;
    private String role;
    public LoggedUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void clearFieldsData() {
        this.id = 0;
        this.username = null;
        this.firstName = null;
        this.role = null;
    }
}
