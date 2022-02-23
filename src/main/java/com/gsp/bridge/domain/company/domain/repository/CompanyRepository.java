package com.gsp.bridge.domain.company.domain.repository;

import com.gsp.bridge.domain.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
