package com.example.thymeleafvalidation.repository;

import com.example.thymeleafvalidation.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Long> {
}
