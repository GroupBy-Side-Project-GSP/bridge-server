package com.gsp.bridge.doamin.notification.domain;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.type.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationEntityTest {

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
}
