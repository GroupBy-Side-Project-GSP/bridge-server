package com.gsp.bridge.domain.notification.service;

import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.NotificationListId;
import com.gsp.bridge.domain.notification.domain.repository.NotificationListRepository;
import com.gsp.bridge.domain.notification.domain.repository.NotificationRepository;
import com.gsp.bridge.domain.notification.exception.NotificationNotFoundException;
import com.gsp.bridge.domain.user.domain.User;
import com.gsp.bridge.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NotificationReadService {

    private final NotificationRepository notificationRepository;
    private final NotificationListRepository notificationListRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Integer notificationId) {
        if (notificationRepository.findById(notificationId).isEmpty()) {
            throw NotificationNotFoundException.EXCEPTION;
        }

        User user = userFacade.getCurrentCompany();

        NotificationListId notificationListId = NotificationListId.builder()
                .notificationEntity(notificationId)
                .user(user.getId())
                .build();

        NotificationList notificationList = notificationListRepository.findById(notificationListId)
                .orElseThrow(() -> NotificationNotFoundException.EXCEPTION);

        notificationList.updateNotificationIsRead();
    }
}
