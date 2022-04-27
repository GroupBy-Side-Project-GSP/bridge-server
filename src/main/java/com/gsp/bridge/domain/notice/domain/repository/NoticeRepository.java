package com.gsp.bridge.domain.notice.domain.repository;

import com.gsp.bridge.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
