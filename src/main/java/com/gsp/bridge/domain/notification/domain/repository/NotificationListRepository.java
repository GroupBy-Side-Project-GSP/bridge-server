package com.gsp.bridge.domain.notification.domain.repository;

import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.NotificationListId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationListRepository extends JpaRepository<NotificationList, NotificationListId> {
}
