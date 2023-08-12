package com.example.modelmapper.entities.dtos;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String city;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String firstName, String lastName, BigDecimal salary, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.salary + " " + this.city;
    }
}
