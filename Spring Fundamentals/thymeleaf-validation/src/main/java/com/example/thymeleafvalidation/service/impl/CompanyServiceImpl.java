package com.example.thymeleafvalidation.service.impl;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;
import com.example.thymeleafvalidation.domain.entities.Company;
import com.example.thymeleafvalidation.repository.CompaniesRepository;
import com.example.thymeleafvalidation.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompaniesRepository companiesRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CompanyServiceImpl(CompaniesRepository companiesRepository, ModelMapper modelMapper) {
        this.companiesRepository = companiesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        Company mapped = modelMapper.map(companyDTO, Company.class);
        Company savedAndFlushed = this.companiesRepository.saveAndFlush(mapped);
        return modelMapper.map(savedAndFlushed, CompanyDTO.class);
    }
}
