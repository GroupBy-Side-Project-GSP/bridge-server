package com.gsp.bridge.domain.notification.domain;

import com.gsp.bridge.domain.notification.domain.type.Type;
import com.gsp.bridge.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_notification")
public class NotificationEntity extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 20)
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Length(max = 8)
    @Enumerated(EnumType.STRING)
    private Type type;

    @NotNull
    private String data;

    @Builder
    public NotificationEntity(String title, String content, Type type, String data) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.data = data;
    }

}
