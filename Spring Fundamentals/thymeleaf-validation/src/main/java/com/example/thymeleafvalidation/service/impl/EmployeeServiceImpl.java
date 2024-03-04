package com.example.thymeleafvalidation.service.impl;

import com.example.thymeleafvalidation.domain.dtos.EmployeeDTO;
import com.example.thymeleafvalidation.domain.entities.Employee;
import com.example.thymeleafvalidation.repository.EmployeesRepository;
import com.example.thymeleafvalidation.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository, ModelMapper modelMapper) {
        this.employeesRepository = employeesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = this.employeesRepository.saveAndFlush(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employeeList = this.employeesRepository.findAll();
        return employeeList
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findEmployeeById(long id) {
        Employee employee = this.employeesRepository.findById(id).orElseThrow();
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
