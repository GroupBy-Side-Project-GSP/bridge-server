package com.gsp.bridge.domain.businesscollaboration.domain;

import com.gsp.bridge.domain.company.domain.Company;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BusinessCollaboration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String companyName;

    @NotNull
    private String profileImageUrl;

    @Column(length = 10, nullable = false)
    private String managerName;

    @Column(length = 11, nullable = false)
    private String companyPhoneNumber;

    @NotNull
    private String collaborationContent;

    @NotNull
    @Length(max = 3)
    @ColumnDefault("YET")
    @Enumerated(EnumType.STRING)
    private ProgressStatus progressStatus;

    @NotNull
    private LocalDateTime createdDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public BusinessCollaboration(String companyName, String profileImageUrl, String managerName,
                                 String companyPhoneNumber, String collaborationContent, ProgressStatus progressStatus,
                                 LocalDateTime createdDateTime, Company company) {
        this.companyName = companyName;
        this.profileImageUrl = profileImageUrl;
        this.managerName = managerName;
        this.companyPhoneNumber = companyPhoneNumber;
        this.collaborationContent = collaborationContent;
        this.progressStatus = progressStatus;
        this.createdDateTime = createdDateTime;
        this.company = company;
    }
}
