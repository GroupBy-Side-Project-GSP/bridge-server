package com.gsp.bridge.domain.notification.domain;

import com.gsp.bridge.domain.notification.domain.type.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
    @Length(max = 20)
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Length(max = 4)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String data;

    @NotNull
    private LocalDateTime createdDatetime;

    @Builder
    public NotificationEntity(String title, String content, Type type, String data, LocalDateTime createdDatetime) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.data = data;
        this.createdDatetime = createdDatetime;
    }

}
