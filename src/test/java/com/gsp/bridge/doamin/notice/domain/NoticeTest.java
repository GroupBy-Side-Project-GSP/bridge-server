package com.gsp.bridge.doamin.notice.domain;

import com.gsp.bridge.domain.company.domain.entity.Company;
import com.gsp.bridge.domain.notice.domain.Notice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class NoticeTest {

    @Test
    void 공지사항_객체_생성_성공_테스트() {
        // given
        String title = "공지사항 제목";
        String content = "공지사항 내용";
        Company company = Company.builder()
                .companyName("company")
                .build();

        // when
        Notice notice = Notice.builder()
                .title(title)
                .content(content)
                .company(company)
                .build();

        // then
        assertAll(
                () -> assertThat(notice).isNotNull(),
                () -> assertThat(notice.getTitle()).isEqualTo(title),
                () -> assertThat(notice.getContent()).isEqualTo(content),
                () -> assertThat(notice.getCompany()).isEqualTo(company)
        );
    }
}
