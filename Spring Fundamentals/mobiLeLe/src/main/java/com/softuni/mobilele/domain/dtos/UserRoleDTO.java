package com.softuni.mobilele.domain.dtos;

public class UserRoleDTO extends BaseEntityDTO {

    private String role;
    public UserRoleDTO(long id) {
        super(id);
    }

    public String getRole() {
        return role;
    }

    public UserRoleDTO setRole(String role) {
        this.role = role;
        return this;
    }
}
