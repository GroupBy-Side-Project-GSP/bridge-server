package com.gsp.bridge.doamin.notice.domain;

import com.gsp.bridge.domain.notice.domain.Notice;
import com.gsp.bridge.domain.notice.domain.NoticeAttachmentFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class NoticeAttachmentFileTest {

    @Test
    void 공지사항_첨부파일_객체_생성_성공_테스트() {
        // given
        String noticeAttachmentFileUrl = "https:/~~~";
        Notice notice = Notice.builder()
                .title("공지사항")
                .build();

        // when
        NoticeAttachmentFile noticeAttachmentFile = NoticeAttachmentFile.builder()
                .noticeAttachmentFileUrl(noticeAttachmentFileUrl)
                .notice(notice)
                .build();

        // then
        assertAll(
                () -> assertThat(noticeAttachmentFile).isNotNull(),
                () -> assertThat(noticeAttachmentFile.getNoticeAttachmentFileUrl()).isEqualTo(noticeAttachmentFileUrl),
                () -> assertThat(noticeAttachmentFile.getNotice()).isEqualTo(notice)
        );
    }
}
