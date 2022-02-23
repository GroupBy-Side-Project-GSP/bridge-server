package com.gsp.bridge.domain.businesscategory.domain.repository;

import com.gsp.bridge.domain.businesscategory.domain.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {
}
