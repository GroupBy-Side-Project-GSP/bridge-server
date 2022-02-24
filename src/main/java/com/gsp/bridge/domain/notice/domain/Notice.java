package com.gsp.bridge.domain.notice.domain;

import com.gsp.bridge.domain.company.domain.Company;
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
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime createDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public Notice(String title, String content, LocalDateTime createDateTime, Company company) {
        this.title = title;
        this.content = content;
        this.createDateTime = createDateTime;
        this.company = company;
    }
}
