package com.gsp.bridge.domain.notification.service;

import com.gsp.bridge.domain.user.domain.User;
import com.gsp.bridge.domain.user.facade.UserFacade;
import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.repository.NotificationListRepository;
import com.gsp.bridge.domain.notification.presentation.response.QueryNotificationListResponse;
import com.gsp.bridge.domain.notification.presentation.response.QueryNotificationListResponse.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * notification_list를 쿼리로 가져옴
 */

@RequiredArgsConstructor
@Service
public class QueryNotificationListService {

    private final NotificationListRepository notificationListRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryNotificationListResponse execute(Pageable pageable) {

        User user = userFacade.getCurrentUser();
        List<NotificationResponse> notificationLists = notificationListRepository.findByUser(user, pageable)
                .stream()
                .map(this::getNotification)
                .collect(Collectors.toList());

        return new QueryNotificationListResponse(notificationLists);
    }

    private NotificationResponse getNotification(NotificationList notificationList) {
        NotificationEntity notificationEntity = notificationList.getNotificationEntity();
        return NotificationResponse.builder()
                .id(notificationEntity.getId())
                .title(notificationEntity.getTitle())
                .content(notificationEntity.getContent())
                .type(notificationEntity.getType())
                .data(notificationEntity.getData())
                .isRead(notificationList.getIsRead())
                .build();
    }

}
