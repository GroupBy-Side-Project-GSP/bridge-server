package com.gsp.bridge.domain.notification.presentation;

import com.gsp.bridge.domain.notification.presentation.response.QueryNotificationListResponse;
import com.gsp.bridge.domain.notification.service.QueryNotificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final QueryNotificationListService queryNotificationListService;

    @GetMapping
    public QueryNotificationListResponse notificationList(Pageable pageable) {
        return queryNotificationListService.execute(pageable);
    }

}
