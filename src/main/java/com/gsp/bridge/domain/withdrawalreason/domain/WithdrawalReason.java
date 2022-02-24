package com.gsp.bridge.domain.withdrawalreason.domain;

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
public class WithdrawalReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime createdDatetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "withdrawal-reason-category-id")
    private WithdrawalReasonCategory withdrawalReasonCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public WithdrawalReason(String title, String content, LocalDateTime createdDatetime, WithdrawalReasonCategory withdrawalReasonCategory, Company company) {
        this.title = title;
        this.content = content;
        this.createdDatetime = createdDatetime;
        this.withdrawalReasonCategory = withdrawalReasonCategory;
        this.company = company;
    }
}
