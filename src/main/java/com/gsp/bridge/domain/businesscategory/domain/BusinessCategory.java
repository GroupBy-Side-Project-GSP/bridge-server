package com.gsp.bridge.domain.businesscategory.domain;

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
    @JoinColumn(name = "InterestIndustry")
    private InterestIndustry interestIndustry;

    @Builder
    public BusinessCategory(String categoryName, InterestIndustry interestIndustry) {
        this.categoryName = categoryName;
        this.interestIndustry = interestIndustry;
    }
}
