package com.gsp.bridge.domain.category.domain.repository;

import com.gsp.bridge.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
