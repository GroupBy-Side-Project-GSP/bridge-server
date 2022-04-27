package com.gsp.bridge.domain.notice.domain;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.global.entity.BaseTimeIdEntity;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_notice")
@Entity
public class Notice extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 20)
    private String title;

    @NotNull
    @Length(max = 2000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Builder
    public Notice(String title, String content, Company company) {
        this.title = title;
        this.content = content;
        this.company = company;
    }
}
