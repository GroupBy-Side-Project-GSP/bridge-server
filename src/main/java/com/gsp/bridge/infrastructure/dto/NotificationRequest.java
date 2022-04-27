package com.gsp.bridge.infrastructure.dto;

import com.gsp.bridge.domain.notification.domain.type.Type;
import com.gsp.bridge.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificationRequest {
    private final User user;
    private final String title;
    private final String content;
    private final String data;
    private final Type type;
    private final String clickAction;
}
