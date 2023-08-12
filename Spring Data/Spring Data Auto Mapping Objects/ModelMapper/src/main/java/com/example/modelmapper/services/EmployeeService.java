package com.example.modelmapper.services;

import com.example.modelmapper.entities.Employee;
import com.example.modelmapper.entities.dtos.CreateEmployeeDTO;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employeeDTO);
}
