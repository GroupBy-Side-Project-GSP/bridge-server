package com.gsp.bridge.domain.notification.domain.repository;

import com.gsp.bridge.domain.notification.domain.NotificationEntity;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<NotificationEntity, Integer> {
}
