package com.gsp.bridge.domain.report.domain.repository;

import com.gsp.bridge.domain.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
