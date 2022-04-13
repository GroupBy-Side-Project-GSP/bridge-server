package com.gsp.bridge.domain.notification.domain.repository;

import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.NotificationListId;
import org.springframework.data.repository.CrudRepository;

public interface NotificationListRepository extends CrudRepository<NotificationList, NotificationListId> {
}
