package com.gsp.bridge.doamin.notification.domain;

import com.gsp.bridge.domain.user.domain.entity.User;
import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.type.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NotificationEntityTest {

    @Test
    void notificaotin_객체생성() {
        //given
        String title = "test notification";
        String content = "testtest notification";
        User user = User.builder()
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
                .userId(user)
                .build();

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(notification, notificationList.getNotificationEntity()),
                () -> Assertions.assertEquals(user, notificationList.getUser())
        );
    }

}
