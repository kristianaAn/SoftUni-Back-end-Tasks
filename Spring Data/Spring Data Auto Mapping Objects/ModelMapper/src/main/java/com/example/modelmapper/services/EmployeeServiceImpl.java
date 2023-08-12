package com.example.modelmapper.services;

import com.example.modelmapper.entities.Address;
import com.example.modelmapper.entities.Employee;
import com.example.modelmapper.entities.dtos.CreateEmployeeDTO;
import com.example.modelmapper.repositories.AddressRepository;
import com.example.modelmapper.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final AddressRepository addressRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Employee create(CreateEmployeeDTO employeeDTO) {
        ModelMapper modelMapper = new ModelMapper();

        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        Optional<Address> byCountryAndCity = addressRepository.findByCountryAndCity(employee.getAddress().getCountry(),
                                                              employee.getAddress().getCity());

        byCountryAndCity.ifPresent(employee::setAddress);

        return employeeRepository.save(employee);
    }
}
