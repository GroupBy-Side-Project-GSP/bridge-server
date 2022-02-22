package com.gsp.bridge.domain.user.domain;

import com.gsp.bridge.global.enums.Authority;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private String companyName;

    @Column
    private String profileImageUrl;

    @Column
    private String companyInformation;

    @Column
    private String companyPhoneNumber;

    @Column
    private String projectExplanation;

    @Column(nullable = false)
    private String managerName;

    @Column(nullable = false)
    private String managerEmail;

    @Column(nullable = false)
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @NotNull
    private LocalDateTime signUpDateTime;

    @Column
    private String simpleProjectExplanation;

    @Column
    private String appDeviceToken;

    @Column
    private String webDeviceToken;

    @Builder
    public User(String email, String password, String companyName, String profileImageUrl, String companyInformation,
                String companyPhoneNumber, String projectExplanation, String managerName, String managerEmail, String address,
                Authority authority, LocalDateTime signUpDateTime, String simpleProjectExplanation,
                String appDeviceToken, String webDeviceToken) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.profileImageUrl = profileImageUrl;
        this.companyInformation = companyInformation;
        this.companyPhoneNumber = companyPhoneNumber;
        this.projectExplanation = projectExplanation;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.address = address;
        this.authority = authority;
        this.signUpDateTime = signUpDateTime;
        this.simpleProjectExplanation = simpleProjectExplanation;
        this.appDeviceToken = appDeviceToken;
        this.webDeviceToken = webDeviceToken;
    }
}
