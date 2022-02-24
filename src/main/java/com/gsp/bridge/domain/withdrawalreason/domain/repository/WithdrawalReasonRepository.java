package com.gsp.bridge.domain.withdrawalreason.domain.repository;

import com.gsp.bridge.domain.withdrawalreason.domain.WithdrawalReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalReasonRepository extends JpaRepository<WithdrawalReason, Long> {
}
