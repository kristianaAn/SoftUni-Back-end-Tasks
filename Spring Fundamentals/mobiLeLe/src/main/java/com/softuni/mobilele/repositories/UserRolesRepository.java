package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRole, Long> {
    //List<UserRole> getAll();
}
