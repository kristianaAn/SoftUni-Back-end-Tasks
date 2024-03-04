package com.example.thymeleafvalidation.service;

import com.example.thymeleafvalidation.domain.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findEmployeeById(long id);
}
