package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.BaseEntity;
import com.softuni.mobilele.domain.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "role", targetEntity = User.class)
    private List<UserRole> roles;

    public UserRole() {
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }
}
