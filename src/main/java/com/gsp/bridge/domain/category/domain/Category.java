package com.gsp.bridge.domain.category.domain;

import com.gsp.bridge.domain.company.domain.entity.Company;
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
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder
    public Category(String title, Company company) {
        this.title = title;
        this.company = company;
    }
}
