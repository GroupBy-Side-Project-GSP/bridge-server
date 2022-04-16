package com.gsp.bridge.doamin.notification.service;

import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.repository.NotificationListRepository;
import com.gsp.bridge.domain.notification.service.NotificationReadService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class NotificationReadTest {

    private final boolean isRead = false;

    private final NotificationList notification = NotificationList.builder().build();

    @Mock
    private NotificationListRepository notificationListRepository;

    @InjectMocks
    private NotificationReadService service;

    @Order(0)
    @Test
    void 알림_읽음여부() {
        assertThat(isRead).isEqualTo(notification.getIsRead());
    }

    @Order(1)
    @Test
    void 알림_확인() {
        notification.updateNotificationIsRead();
        assertTrue(notification.getIsRead());
    }

}
