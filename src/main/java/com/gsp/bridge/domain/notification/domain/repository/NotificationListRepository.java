package com.gsp.bridge.domain.notification.domain.repository;

import com.gsp.bridge.domain.user.domain.User;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.NotificationListId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface NotificationListRepository extends CrudRepository<NotificationList, NotificationListId> {

    Page<NotificationList> findByUser(User user, Pageable pageable);
}
