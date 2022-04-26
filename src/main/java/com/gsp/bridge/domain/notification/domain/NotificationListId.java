package com.gsp.bridge.domain.notification.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode
public class NotificationListId implements Serializable {

    private Integer notificationEntity;

    private Integer user;

}
