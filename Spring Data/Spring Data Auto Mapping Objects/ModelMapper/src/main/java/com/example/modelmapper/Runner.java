package com.example.modelmapper;

import com.example.modelmapper.entities.Address;
import com.example.modelmapper.entities.Employee;
import com.example.modelmapper.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        ModelMapper modelMapper = new ModelMapper();
//        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                map().setCity(source.getAddress().getCity());
//            }
//        };
//
//        modelMapper.addMappings(propertyMap);

//        TypeMap<Employee, EmployeeDTO> employeeDTOTypeMap = modelMapper.createTypeMap(Employee.class, EmployeeDTO.class);
//        employeeDTOTypeMap.addMappings(mapping -> mapping.map(
//                        source -> source.getAddress().getCity(),
//                        EmployeeDTO::setCity));
//
//        employeeDTOTypeMap.validate();
//
//        Address address = new Address("Bulgaria", "Varna");
//        Employee employee = new Employee("Ivan", "Ivanov", BigDecimal.valueOf(1500.00), address);
//
//        EmployeeDTO employeeDTO = employeeDTOTypeMap.map(employee);
//
//        System.out.println(employeeDTO);
    }
}
