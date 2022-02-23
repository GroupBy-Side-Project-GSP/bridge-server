package com.gsp.bridge.domain.interestindustry.domain.repository;

import com.gsp.bridge.domain.interestindustry.domain.InterestIndustry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestIndustryRepository extends JpaRepository<InterestIndustry, Long> {
}
