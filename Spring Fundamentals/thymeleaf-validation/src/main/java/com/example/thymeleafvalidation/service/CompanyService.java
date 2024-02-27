package com.example.thymeleafvalidation.service;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;

public interface CompanyService {
    CompanyDTO saveCompany(CompanyDTO companyDTO);
}
