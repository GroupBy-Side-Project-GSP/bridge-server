package com.gsp.bridge.domain.company.domain.entity.repository;

import com.gsp.bridge.domain.company.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByAccountId(String accountId);
}
