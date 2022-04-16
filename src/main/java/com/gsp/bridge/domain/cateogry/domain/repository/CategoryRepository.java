package com.gsp.bridge.domain.cateogry.domain.repository;

import com.gsp.bridge.domain.cateogry.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
