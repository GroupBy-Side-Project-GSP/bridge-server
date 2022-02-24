package com.gsp.bridge.domain.businesscategory.domain;

import com.gsp.bridge.domain.company.domain.Company;
import com.gsp.bridge.domain.interestindustry.domain.InterestIndustry;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BusinessCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interested-industry-id")
    private InterestIndustry interestIndustry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public BusinessCategory(String categoryName, InterestIndustry interestIndustry, Company company) {
        this.categoryName = categoryName;
        this.interestIndustry = interestIndustry;
        this.company = company;
    }
}
