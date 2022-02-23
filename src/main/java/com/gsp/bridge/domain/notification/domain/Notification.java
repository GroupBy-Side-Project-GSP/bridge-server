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
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20, nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String content;

    private Type type;

    @NotNull
    private LocalDateTime createdDatetime;

    @Builder
    public Notification(String title, String content, Type type, LocalDateTime createdDatetime) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.createdDatetime = createdDatetime;
    }

}
