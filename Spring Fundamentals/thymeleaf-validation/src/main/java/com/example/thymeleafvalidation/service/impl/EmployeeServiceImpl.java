package com.example.thymeleafvalidation.service.impl;

import com.example.thymeleafvalidation.domain.dtos.EmployeeDTO;
import com.example.thymeleafvalidation.domain.entities.Company;
import com.example.thymeleafvalidation.domain.entities.Employee;
import com.example.thymeleafvalidation.repository.CompaniesRepository;
import com.example.thymeleafvalidation.repository.EmployeesRepository;
import com.example.thymeleafvalidation.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;
    private final ModelMapper modelMapper;
    private final CompaniesRepository companiesRepository;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository, CompaniesRepository companiesRepository,
                               ModelMapper modelMapper) {
        this.employeesRepository = employeesRepository;
        this.modelMapper = modelMapper;
        this.companiesRepository = companiesRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Company company = this.companiesRepository.findByName(employeeDTO.getCompany());
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setCompany(company);
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
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        employeeDTO.setCompany(employee.getCompany().getName());
        return employeeDTO;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeesRepository.deleteById(id);
    }
}
