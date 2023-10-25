package com.softuni.mobilele.services.impl;

import com.softuni.mobilele.domain.entities.UserRole;
import com.softuni.mobilele.domain.enums.Role;
import com.softuni.mobilele.services.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<>();

        userRoles.add(new UserRole().setRole(Role.ADMIN));
        userRoles.add(new UserRole().setRole(Role.USER));

        return userRoles;
    }
}
