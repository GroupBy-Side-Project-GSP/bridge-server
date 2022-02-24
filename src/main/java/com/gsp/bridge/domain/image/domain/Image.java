package com.gsp.bridge.domain.image.domain;

import com.gsp.bridge.domain.notice.domain.Notice;
import com.gsp.bridge.domain.report.domain.Report;
import com.gsp.bridge.domain.withdrawalreason.domain.WithdrawalReason;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report-id")
    private Report report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice-id")
    private Notice notice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback-id")
    private Feedback feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "withdrawal-reason-id")
    private WithdrawalReason withdrawalReason;

    @Builder
    public Image(String imageURL, Report report, Notice notice,
                 Feedback feedback, WithdrawalReason withdrawalReason) {
        this.imageURL = imageURL;
        this.report = report;
        this.notice = notice;
        this.feedback = feedback;
        this.withdrawalReason = withdrawalReason;
    }
}
