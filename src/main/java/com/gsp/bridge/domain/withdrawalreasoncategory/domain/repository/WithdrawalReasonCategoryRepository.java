package com.gsp.bridge.domain.withdrawalreasoncategory.domain.repository;

import com.gsp.bridge.domain.withdrawalreasoncategory.domain.WithdrawalReasonCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalReasonCategoryRepository extends JpaRepository<WithdrawalReasonCategory, Long> {
}
