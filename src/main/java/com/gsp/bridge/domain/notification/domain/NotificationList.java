package com.gsp.bridge.domain.notification.domain;

import com.gsp.bridge.domain.company.domain.Company;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(NotificationListId.class)
@Entity
@Table(name="tbl_notification_list")
public class NotificationList {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification-id")
    private NotificationEntity notificationEntity;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @ColumnDefault("0")
    @Column(nullable = false)
    private Boolean isRead;

    @Builder
    public NotificationList(NotificationEntity notificationEntity, Company company) {
        this.notificationEntity = notificationEntity;
        this.company = company;
        this.isRead = false;
    }
}
