package com.gsp.bridge.domain.interestindustry.domain;

import com.gsp.bridge.domain.company.domain.Company;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_interest_industry")
public class InterestIndustry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String interestIndustryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public InterestIndustry(String interestIndustryName, Company company) {
        this.interestIndustryName = interestIndustryName;
        this.company = company;
    }
}
