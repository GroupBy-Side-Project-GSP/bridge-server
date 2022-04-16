package com.gsp.bridge.domain.notification.presentation;

import com.gsp.bridge.domain.notification.presentation.response.QueryNotificationListResponse;
import com.gsp.bridge.domain.notification.service.NotificationReadService;
import com.gsp.bridge.domain.notification.service.QueryNotificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final QueryNotificationListService queryNotificationListService;
    private final NotificationReadService notificationReadService;

    @GetMapping
    public QueryNotificationListResponse notificationList(Pageable pageable) {
        return queryNotificationListService.execute(pageable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{notification-id}")
    public void notificationRead(@PathVariable("notification-id") Long notificationId) {
        notificationReadService.execute(notificationId);
    }
}
