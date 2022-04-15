package com.gsp.bridge.domain.notification.presentation.response;

import com.gsp.bridge.domain.notification.domain.type.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryNotificationListResponse {

    private final List<NotificationResponse> notificationList;

    @Getter
    @Builder
    public static class NotificationResponse {
        private final Integer id;
        private final String title;
        private final String content;
        private final Type type;
        private final String data;
        private final boolean isRead;
    }
}
