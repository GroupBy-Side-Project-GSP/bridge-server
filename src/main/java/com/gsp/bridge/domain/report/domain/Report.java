package com.gsp.bridge.domain.report.domain;

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
@Table(name = "tbl_report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    private String content;

    @NotNull
    private LocalDateTime createdDatetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public Report(String title, String content, LocalDateTime createdDatetime, Company company) {
        this.title = title;
        this.content = content;
        this.createdDatetime = createdDatetime;
        this.company = company;
    }
}
