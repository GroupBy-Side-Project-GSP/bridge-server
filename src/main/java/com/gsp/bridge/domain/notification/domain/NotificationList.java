package com.gsp.bridge.domain.notification.domain;

import com.gsp.bridge.domain.company.domain.entity.Company;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "tbl_notification_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(NotificationListId.class)
@Entity
public class NotificationList {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id")
    private NotificationEntity notificationEntity;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Company company;

    @NotNull
    @ColumnDefault("0")
    private Boolean isRead;

    @Builder
    public NotificationList(NotificationEntity notificationEntity, Company companyId) {
        this.notificationEntity = notificationEntity;
        this.company = companyId;
        this.isRead = false;
    }

}
