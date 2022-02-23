package com.gsp.bridge.domain.company.domain;

import com.gsp.bridge.global.enums.Authority;
import com.gsp.bridge.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    private String profileImageUrl;

    @NotNull
    private String companyName;

    private String companyInformation;

    private String projectExplanation;

    @Column(length = 10, nullable = false)
    private String managerName;

    @Column(length = 64, nullable = false)
    private String managerEmail;

    @Column(length = 11, nullable = false)
    private String companyPhoneNumber;

    @Column(length = 93, nullable = false)
    private String address;

    @NotNull
    private LocalDateTime signUpDateTime;

    private String simpleProjectExplanation;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column(length = 64)
    private String appDeviceToken;

    @Column(length = 64)
    private String webDeviceToken;

    public Company(String email, String password, String profileImageUrl, String companyName,
                   String companyInformation, String projectExplanation, String managerName,
                   String managerEmail, String companyPhoneNumber, String address, LocalDateTime signUpDateTime,
                   String simpleProjectExplanation, Authority authority, String appDeviceToken, String webDeviceToken) {
        this.email = email;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.companyName = companyName;
        this.companyInformation = companyInformation;
        this.projectExplanation = projectExplanation;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.address = address;
        this.signUpDateTime = signUpDateTime;
        this.simpleProjectExplanation = simpleProjectExplanation;
        this.authority = authority;
        this.appDeviceToken = appDeviceToken;
        this.webDeviceToken = webDeviceToken;
    }

}
