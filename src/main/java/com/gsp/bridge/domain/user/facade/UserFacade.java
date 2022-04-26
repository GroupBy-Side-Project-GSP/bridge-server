package com.gsp.bridge.domain.user.facade;

import com.gsp.bridge.domain.user.domain.User;
import com.gsp.bridge.domain.user.domain.UserRepository;
import com.gsp.bridge.domain.user.exception.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentCompany() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getCompanyByAccountId(accountId);
    }

    public User getCompanyByAccountId(String id) {
        return userRepository.findByAccountId(id)
                .orElseThrow(() -> CompanyNotFoundException.EXCEPTION);
    }

}
