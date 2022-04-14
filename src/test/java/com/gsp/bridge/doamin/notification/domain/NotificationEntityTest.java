package com.gsp.bridge.doamin.notification.domain;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.type.Type;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationEntityTest {

    private final String title = "Test title";

    private final String content = "Test content";

    private final boolean isRead = false;

    private final NotificationList notification = NotificationList.builder().build();

    @Test
    @DisplayName("Builder를 할용하여 NotificationEntity객체를 생성하는 메소드")
    void createByBuilder() {
        //given
        String title = "test notification";
        String content = "testtest notification";
        Company company = Company.builder()
                .companyName("회사")
                .build();
        //when
        NotificationEntity notification = NotificationEntity.builder()
                .title(title)
                .content(content)
                .type(Type.NOTICE)
                .data("1")
                .build();

        NotificationList notificationList = NotificationList.builder()
                .notificationEntity(notification)
                .companyId(company)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(notification, notificationList.getNotificationEntity()),
                () -> Assertions.assertEquals(company, notificationList.getCompany())
        );
    }

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
