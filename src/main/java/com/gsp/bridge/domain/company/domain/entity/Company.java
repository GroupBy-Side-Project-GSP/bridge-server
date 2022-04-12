package com.gsp.bridge.domain.company.domain.entity;

import com.gsp.bridge.domain.company.domain.entity.type.Authority;
import com.gsp.bridge.global.entity.BaseTimeIdEntity;
import com.gsp.bridge.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class Company extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 64)
    private String email;

    @NotNull
    @Length(max = 50)
    private String accountId;

    @NotNull
    @Length(max = 64)
    private String password;

    @NotNull
    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    private String profileImageUrl;

    @NotNull
    private String companyName;

    @Length(max = 1000)
    private String companyInformation;

    @NotNull
    @Length(max = 64)
    private String managerEmail;

    @NotNull
    @Length(max = 11)
    private String companyPhoneNumber;

    @NotNull
    @Length(max = 93)
    private String address;

    @Length(max = 64)
    private String appDeviceToken;

    @Length(max = 64)
    private String webDeviceToken;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Company(String email, String accountId, String password, String profileImageUrl,
                   String companyName, String companyInformation, String managerEmail,
                   String companyPhoneNumber, String address, String appDeviceToken,
                   String webDeviceToken, Authority authority) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.profileImageUrl = profileImageUrl;
        this.companyName = companyName;
        this.companyInformation = companyInformation;
        this.managerEmail = managerEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.address = address;
        this.appDeviceToken = appDeviceToken;
        this.webDeviceToken = webDeviceToken;
        this.authority = authority;
    }
}
