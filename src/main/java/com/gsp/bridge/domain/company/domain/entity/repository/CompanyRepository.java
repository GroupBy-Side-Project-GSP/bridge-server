package com.gsp.bridge.domain.company.domain.entity.repository;

import com.gsp.bridge.domain.company.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
