package com.gsp.bridge.domain.notification.domain;

import com.gsp.bridge.domain.notification.domain.type.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Enumerated(EnumType.STRING)
    private Type type;

    @NotNull
    private LocalDateTime createdDatetime;

    @Builder
    public NotificationEntity(String title, String content, Type type, LocalDateTime createdDatetime) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.createdDatetime = createdDatetime;
    }

}
