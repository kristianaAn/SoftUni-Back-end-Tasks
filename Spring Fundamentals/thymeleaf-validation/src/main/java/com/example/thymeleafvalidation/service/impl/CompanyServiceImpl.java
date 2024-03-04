package com.example.thymeleafvalidation.service.impl;

import com.example.thymeleafvalidation.domain.dtos.CompanyDTO;
import com.example.thymeleafvalidation.domain.entities.Company;
import com.example.thymeleafvalidation.repository.CompaniesRepository;
import com.example.thymeleafvalidation.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<CompanyDTO> findAllCompanies() {
        List<Company> companyList = this.companiesRepository.findAll();
        return companyList.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Company findCompanyById(long id) {
        return this.companiesRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteCompanyById(long id) {
        this.companiesRepository.deleteById(id);
    }
}
