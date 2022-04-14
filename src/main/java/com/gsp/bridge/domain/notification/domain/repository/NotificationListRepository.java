package com.gsp.bridge.domain.notification.domain.repository;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.notification.domain.NotificationList;
import com.gsp.bridge.domain.notification.domain.NotificationListId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface NotificationListRepository extends CrudRepository<NotificationList, NotificationListId> {

    Page<NotificationList> findByCompany(Company company, Pageable pageable);
}
