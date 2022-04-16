package com.gsp.bridge.domain.notification.service;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.company.facade.CompanyFacade;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.NotificationListId;
import com.gsp.bridge.domain.notification.domain.repository.NotificationListRepository;
import com.gsp.bridge.domain.notification.domain.repository.NotificationRepository;
import com.gsp.bridge.domain.notification.exception.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NotificationReadService {

    private final NotificationRepository notificationRepository;
    private final NotificationListRepository notificationListRepository;
    private final CompanyFacade companyFacade;

    @Transactional
    public void execute(Long notificationId) {
        if (notificationRepository.findById(notificationId).isEmpty()) {
            throw NotificationNotFoundException.EXCEPTION;
        }

        Company company = companyFacade.getCurrentCompany();

        NotificationListId notificationListId = NotificationListId.builder()
                .notificationEntity(notificationId)
                .company(company.getId())
                .build();

        NotificationList notificationList = notificationListRepository.findById(notificationListId)
                .orElseThrow(() -> NotificationNotFoundException.EXCEPTION);

        notificationList.updateNotificationIsRead();
    }
}
