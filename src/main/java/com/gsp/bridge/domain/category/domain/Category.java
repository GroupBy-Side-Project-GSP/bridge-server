package com.gsp.bridge.domain.category.domain;

import com.gsp.bridge.domain.user.domain.User;
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
@Table(name = "tbl_category")
@Entity
public class Category extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 255)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Category(String title, User user) {
        this.title = title;
        this.user = user;
    }
}