package com.gsp.bridge.domain.notice.domain;

import com.gsp.bridge.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_notice_attachment_file")
@Entity
public class NoticeAttachmentFile extends BaseTimeIdEntity {

    @Length(max = 255)
    @NotNull
    private String noticeAttachmentFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @Builder
    public NoticeAttachmentFile(String noticeAttachmentFileUrl, Notice notice) {
        this.noticeAttachmentFileUrl = noticeAttachmentFileUrl;
        this.notice = notice;
    }
}
