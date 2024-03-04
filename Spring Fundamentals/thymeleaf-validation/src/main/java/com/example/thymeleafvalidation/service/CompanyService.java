package com.example.thymeleafvalidation.service;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;
import com.example.thymeleafvalidation.domain.entities.Company;

import java.util.List;

public interface CompanyService {
    CompanyDTO saveCompany(CompanyDTO companyDTO);

    List<CompanyDTO> findAllCompanies();

    Company findCompanyById(long id);

    void deleteCompanyById(long id);
}
