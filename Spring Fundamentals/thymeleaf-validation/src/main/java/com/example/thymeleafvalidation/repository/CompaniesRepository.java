package com.example.thymeleafvalidation.repository;

import com.example.thymeleafvalidation.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Long> {

    @Override
    List<Company> findAll();

    @Override
    Optional<Company> findById(Long id);

    @Override
    void deleteById(Long id);

    Company findByName(String name);

}
