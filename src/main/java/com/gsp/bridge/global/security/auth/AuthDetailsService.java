package com.gsp.bridge.global.security.auth;

import com.gsp.bridge.domain.company.domain.entity.repository.CompanyRepository;
import com.gsp.bridge.domain.company.exception.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        return companyRepository.findByAccountId(accountId)
                .map(AuthDetails::new)
                .orElseThrow(() -> CompanyNotFoundException.EXCEPTION);
    }

}
