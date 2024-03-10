package com.example.thymeleafvalidation.repository;

import com.example.thymeleafvalidation.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Override
    Optional<Employee> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

}
