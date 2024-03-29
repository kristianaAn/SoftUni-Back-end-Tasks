package com.example.modelmapper;

import com.example.modelmapper.entities.Address;
import com.example.modelmapper.entities.Employee;
import com.example.modelmapper.entities.dtos.AddressDTO;
import com.example.modelmapper.entities.dtos.CreateEmployeeDTO;
import com.example.modelmapper.services.AddressService;
import com.example.modelmapper.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class MainRunner implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    @Autowired
    public MainRunner(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

//        createAddress(scanner);
        createEmployee(scanner);
    }

    private void createEmployee(Scanner scanner) {
        String firstName = scanner.nextLine();
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        LocalDate birthday = LocalDate.parse(scanner.nextLine());
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

        Employee employee = employeeService.create(employeeDTO);

        System.out.println(employee);

    }

    private void createAddress(Scanner scanner) {
        String country = scanner.nextLine();
        String city = scanner.nextLine();

        AddressDTO data = new AddressDTO(country, city);

        Address address = addressService.create(data);
        System.out.println(address);
    }
}
