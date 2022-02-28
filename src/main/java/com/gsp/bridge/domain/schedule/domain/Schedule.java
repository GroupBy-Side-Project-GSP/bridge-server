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
@Table(name = "tbl_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime scheduleDatetime;

    @NotNull
    private LocalDateTime alarmDateTime;

    @NotNull
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company-id")
    private Company company;

    @Builder
    public Schedule(LocalDateTime scheduleDatetime, LocalDateTime alarmDateTime, Company company) {
        this.scheduleDatetime = scheduleDatetime;
        this.alarmDateTime = alarmDateTime;
        this.company = company;
    }
}
