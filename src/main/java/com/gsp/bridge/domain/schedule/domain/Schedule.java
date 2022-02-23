package com.gsp.bridge.domain.schedule.domain;

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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime scheduleDatetime;

    @NotNull
    private LocalDateTime alarmDatetime;

    @NotNull
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public Schedule(LocalDateTime scheduleDatetime, LocalDateTime alarmDatetime, Company company) {
        this.scheduleDatetime = scheduleDatetime;
        this.alarmDatetime = alarmDatetime;
        this.company = company;
    }
}
