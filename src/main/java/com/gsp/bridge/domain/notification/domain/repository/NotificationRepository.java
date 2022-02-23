package com.gsp.bridge.domain.notification.domain.repository;

import com.gsp.bridge.domain.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
