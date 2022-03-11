package com.gsp.bridge.domain.notification.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@EqualsAndHashCode
public class NotificationListId implements Serializable {

    private Long notificationEntity;

    private Long company;
}
