package com.gsp.bridge.domain.company.facade;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.company.domain.entity.repository.CompanyRepository;
import com.gsp.bridge.domain.company.exception.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyFacade {

    private final CompanyRepository companyRepository;

    public Company getCurrentCompany() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getCompanyByAccountId(accountId);
    }

    public Company getCompanyByAccountId(String id) {
        return companyRepository.findByAccountId(id)
                .orElseThrow(() -> CompanyNotFoundException.EXCEPTION);
    }

}
